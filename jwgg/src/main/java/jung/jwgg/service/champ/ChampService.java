package jung.jwgg.service.champ;

import jung.jwgg.domain.champ.AddCounterFormV2;
import jung.jwgg.domain.champ.Champ;
import jung.jwgg.repository.champ.ChampRecoCond;
import jung.jwgg.web.champ.form.AddCounterDto;
import jung.jwgg.web.champ.form.SearchCountDto;

import java.io.IOException;
import java.util.List;

public interface ChampService {
    List<Champ> recommendChamp(ChampRecoCond cond);

    Champ save(Champ champ);

    Champ findChamp(String champName);

    void counterSave(AddCounterDto addCounterDto);

    int dedupe(AddCounterDto addCounterDto);

    List<AddCounterFormV2> countedChamp(SearchCountDto searchCount);

    void deleteCounter(AddCounterDto addCounterDto);

    String scrapeHeadToHeadWinRate(String championName1, String championName2) throws IOException;
}
