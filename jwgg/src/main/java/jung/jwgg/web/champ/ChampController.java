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
import jung.jwgg.web.item.form.ItemSaveForm;
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
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/champs")
@RequiredArgsConstructor
public class ChampController {

    private final ChampService champService;

    @GetMapping
    public String champs(@ModelAttribute("cond") ChampRecoCond cond, Model model, HttpServletRequest request) {
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

        if (cond.getRedChampName1() != null && !cond.getRedChampName1().isEmpty()) {
            Champ findedChamp = champService.findChamp(cond.getRedChampName1());
            cond.setRedChampId1(findedChamp.getChampId());
        }
        if (cond.getRedChampName2() != null && !cond.getRedChampName2().isEmpty()) {
            Champ findedChamp = champService.findChamp(cond.getRedChampName2());
            cond.setRedChampId2(findedChamp.getChampId());
        }
        if (cond.getRedChampName3() != null && !cond.getRedChampName3().isEmpty()) {
            Champ findedChamp = champService.findChamp(cond.getRedChampName3());
            cond.setRedChampId3(findedChamp.getChampId());
        }
        if (cond.getRedChampName4() != null && !cond.getRedChampName4().isEmpty()) {
            Champ findedChamp = champService.findChamp(cond.getRedChampName4());
            cond.setRedChampId4(findedChamp.getChampId());
        }
        if (cond.getRedChampName5() != null && !cond.getRedChampName5().isEmpty()) {
            Champ findedChamp = champService.findChamp(cond.getRedChampName5());
            cond.setRedChampId5(findedChamp.getChampId());
        }

        log.info("{}",cond);
        List<Champ> champs = champService.recommendChamp(cond);
        model.addAttribute("champs", champs);
        return "champs/champs";
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
                              @PathVariable("registerChampName") String registerChampName, @PathVariable("counter") String counter,
                              @PathVariable("searchChamp") String searchChamp,
                              RedirectAttributes redirectAttributes) {
        Integer id = champService.findChamp(registerChampName).getChampId();
        Integer cid = champService.findChamp(counter).getChampId();

        AddCounterDto addCounterDto = new AddCounterDto(loginMember.getId(), id, cid);

        champService.deleteCounter(addCounterDto);

        redirectAttributes.addAttribute("searchChamp", searchChamp);

        return "redirect:/champs/add";
    }
}
