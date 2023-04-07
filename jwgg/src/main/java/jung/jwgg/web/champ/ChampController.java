package jung.jwgg.web.champ;

import jung.jwgg.domain.champ.Champ;
import jung.jwgg.repository.champ.ChampRecoCond;
import jung.jwgg.service.champ.ChampService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
