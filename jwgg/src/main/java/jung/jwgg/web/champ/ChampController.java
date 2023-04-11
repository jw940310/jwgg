package jung.jwgg.web.champ;

import jung.jwgg.domain.champ.AddCounterFormV2;
import jung.jwgg.domain.champ.Champ;
import jung.jwgg.domain.item.Item;
import jung.jwgg.domain.member.Member;
import jung.jwgg.repository.champ.ChampRecoCond;
import jung.jwgg.service.champ.ChampService;
import jung.jwgg.web.SessionConst;
import jung.jwgg.web.champ.form.AddCounterDto;
import jung.jwgg.web.champ.form.AddCounterForm;
import jung.jwgg.web.champ.form.SearchCountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/champs")
@RequiredArgsConstructor
public class ChampController {

    private final ChampService champService;

    @GetMapping
    public String champs(@ModelAttribute("cond") ChampRecoCond cond, Model model, HttpServletRequest request, BindingResult bindingResult) throws IOException {
/*        for (String redName : cond.getRedNames()) {
            if (redName != null && !redName.isEmpty()) {
                Champ findChamp = champService.findChamp(redName);
                cond.addRedTeam(findChamp.getChampId());
            }
        }
        log.info("complete,{}",cond.getRedTeam());*/

        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        Long id = member.getId();
        cond.setLoginId(id);

        checkWord(cond, bindingResult, cond.getRedChampName1());
        checkWord(cond, bindingResult, cond.getRedChampName2());
        checkWord(cond, bindingResult, cond.getRedChampName3());
        checkWord(cond, bindingResult, cond.getRedChampName4());
        checkWord(cond, bindingResult, cond.getRedChampName5());
        // 적 챔피언 검사
        checkWord(cond, bindingResult, cond.getBlueChampName1());
        checkWord(cond, bindingResult, cond.getBlueChampName2());
        checkWord(cond, bindingResult, cond.getBlueChampName3());
        checkWord(cond, bindingResult, cond.getBlueChampName4());

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "champs/champs";
        }

        cond.setWinRate1(checkWinRate(cond, cond.getRedChampName1(), cond.getBlueChampName1()));
        cond.setWinRate2(checkWinRate(cond, cond.getRedChampName2(), cond.getBlueChampName2()));
        cond.setWinRate3(checkWinRate(cond, cond.getRedChampName3(), cond.getBlueChampName3()));
        cond.setWinRate4(checkWinRate(cond, cond.getRedChampName4(), cond.getBlueChampName4()));

        log.info("{}",cond);
        List<Champ> champs = champService.recommendChamp(cond);
        model.addAttribute("champs", champs);
        return "champs/champs";
    }

    private String checkWinRate(@ModelAttribute("cond") ChampRecoCond cond, String redChampName, String blueChampName) throws IOException {
        if (redChampName != null && !redChampName.isEmpty() && blueChampName != null && !blueChampName.isEmpty()) {
            if (champService.findChamp(redChampName) != null && champService.findChamp(blueChampName) != null) {
                if (champService.findChamp(redChampName).getChampLine().equals(champService.findChamp(blueChampName).getChampLine())) {
                    String champEngName1 = champService.findChamp(redChampName).getChampEngName();
                    String champEngName2 = champService.findChamp(blueChampName).getChampEngName();
                    String champEngLine = champService.findChamp(redChampName).getChampEngLine();
                    return champService.scrapeHeadToHeadWinRate(champEngName2, champEngName1, champEngLine);
                }
            }
        }
        return null;
    }

    private void checkWord(@ModelAttribute("cond") ChampRecoCond cond, BindingResult bindingResult, String redChampName) {
        if (redChampName != null && !redChampName.isEmpty()) {
            if (champService.findChamp(redChampName) == null) {
                bindingResult.reject("noSuchChamp");
            } else {
                Champ findedChamp = champService.findChamp(redChampName);
                cond.setRedChampId1(findedChamp.getChampId());
            }
        }
    }

    @GetMapping("/add")
    public String addForm(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)Member loginMember, @ModelAttribute("champ") AddCounterFormV2 form, Model model) {
        //로그인 여부 체크
        model.addAttribute("champ2", new Champ());

        SearchCountDto searchCount = new SearchCountDto(loginMember.getId(), form.getSearchChamp());
        List<AddCounterFormV2> champs = champService.countedChamp(searchCount);
        model.addAttribute("champs", champs);

        return "champs/addCounter";
    }

    @PostMapping("/add")
    public String addCounter(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)Member loginMember,
                             @Valid @ModelAttribute("champ") AddCounterForm form, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {

        SearchCountDto searchCount = new SearchCountDto(loginMember.getId(), form.getSearchChamp());
        List<AddCounterFormV2> champs = champService.countedChamp(searchCount);
        model.addAttribute("champs", champs);


        //특정 필드 예외가 아닌 전체 예외
        if (form.getRegisterChampName() != null && form.getCounter() != null) {
            if (champService.findChamp(form.getRegisterChampName()) == null || champService.findChamp(form.getCounter())==null) {
                bindingResult.reject("noSuchChamp");
            }
        }

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "champs/addCounter";
        }

        Integer id = champService.findChamp(form.getRegisterChampName()).getChampId();
        Integer cid = champService.findChamp(form.getCounter()).getChampId();
        AddCounterDto addCounterDto = new AddCounterDto(loginMember.getId(), id, cid);

        if (champService.dedupe(addCounterDto) > 0) {
            bindingResult.reject("dedupe");
        }

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "champs/addCounter";
        }

        //성공 로직

        log.info("{},{}",id,cid);

        champService.counterSave(addCounterDto);

        SearchCountDto searchCount2 = new SearchCountDto(loginMember.getId(), form.getSearchChamp());
        List<AddCounterFormV2> champs2 = champService.countedChamp(searchCount2);
        model.addAttribute("champs", champs2);

        return "champs/addCounter";
    }
    @PostMapping("/delete/{registerChampName}/{counter}/{searchChamp}")
    public String deleteChamp(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)Member loginMember,
                              @PathVariable(required = false) String registerChampName, @PathVariable(required = false) String counter,
                              @PathVariable(required = false) String searchChamp,
                              RedirectAttributes redirectAttributes) {
        Integer id = champService.findChamp(registerChampName).getChampId();
        Integer cid = champService.findChamp(counter).getChampId();

        AddCounterDto addCounterDto = new AddCounterDto(loginMember.getId(), id, cid);

        champService.deleteCounter(addCounterDto);

        if (searchChamp != null) {
            redirectAttributes.addAttribute("searchChamp", searchChamp);
        }

        return "redirect:/champs/add";
    }
    @PostMapping("/delete/{registerChampName}/{counter}/")
    public String deleteChamp2(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)Member loginMember,
                              @PathVariable(required = false) String registerChampName, @PathVariable(required = false) String counter) {
        Integer id = champService.findChamp(registerChampName).getChampId();
        Integer cid = champService.findChamp(counter).getChampId();

        AddCounterDto addCounterDto = new AddCounterDto(loginMember.getId(), id, cid);

        champService.deleteCounter(addCounterDto);

        return "redirect:/champs/add";
    }
}
