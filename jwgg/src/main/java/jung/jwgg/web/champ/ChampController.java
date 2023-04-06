package jung.jwgg.web.champ;

import jung.jwgg.domain.champ.Champ;
import jung.jwgg.service.champ.ChampService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/champs")
@RequiredArgsConstructor
public class ChampController {

    private final ChampService champService;

    @GetMapping
    public String champs(@ModelAttribute("champ") Champ champ, Model model) {
        if (champ.getChampName() != null && !champ.getChampName().isEmpty()) {
            Champ findedChamp = champService.findChamp(champ.getChampName());
            findedChamp.setChampLine(champ.getChampLine());
            List<Champ> champs = champService.recommendChamp(findedChamp);
            model.addAttribute("champs", champs);
            log.info("설정된 챔피언 정보 = {}", findedChamp);

        }
        else {
            List<Champ> champs = champService.recommendChamp(champ);
            model.addAttribute("champs", champs);
        }
        return "champs/champs";
    }
}
