package jung.jwgg.web.champ;

import jung.jwgg.domain.champ.Champ;
import jung.jwgg.domain.item.Item;
import jung.jwgg.repository.champ.ChampRecoCond;
import jung.jwgg.service.champ.ChampService;
import jung.jwgg.web.champ.form.AddCounterForm;
import jung.jwgg.web.item.form.ItemSaveForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String champs(@ModelAttribute("cond") ChampRecoCond cond, Model model) {
/*        for (String redName : cond.getRedNames()) {
            if (redName != null && !redName.isEmpty()) {
                Champ findChamp = champService.findChamp(redName);
                cond.addRedTeam(findChamp.getChampId());
            }
        }
        log.info("complete,{}",cond.getRedTeam());*/

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
    public String addForm(Model model) {
        //로그인 여부 체크
        model.addAttribute("champ", new AddCounterForm());
        return "champs/addCounter";
    }

    @PostMapping("/add")
    public String addCounter(@Valid @ModelAttribute("champ") AddCounterForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

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
        if (champService.dedupe(id, cid) > 0) {
            bindingResult.reject("dedupe");
        }

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "champs/addCounter";
        }


        //성공 로직

        log.info("{},{}",id,cid);

        champService.counterSave(id,cid);

        return "champs/addCounter";
    }

}
