package jung.jwgg.repository.champ;

import jung.jwgg.domain.champ.Champ;
import jung.jwgg.service.champ.ChampService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Transactional
@SpringBootTest
class ChampRepositoryTest {
    @Autowired
    ChampService champService;

    @Test
    void test() throws IOException {
        champService.scrapeHeadToHeadWinRate("vayne", "kaisa","bottom");
    }
/*
    @Test
    void recommendChamp() {
        Champ newChamp = new Champ("르블랑","미드"); // 5
        champRepository.save(newChamp);
        ChampRecoCond cond = new ChampRecoCond();
        cond.setRedChampName1("카이사");
        cond.setChampLine("원딜");
        List<Champ> champs = champRepository.recommendChamp(cond);
        Assertions.assertThat(champs.size()).isEqualTo(2);
    }
*/

//    void test(Integer champId, Item... items) {
//        List<Champ> champs = champRepository.recommendChamp(champId);
//        assertThat(champs).containsExactly(items); // 순서도 맞아야함(containsExactly)
//    }

}