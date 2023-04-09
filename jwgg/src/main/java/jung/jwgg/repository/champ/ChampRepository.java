package jung.jwgg.repository.champ;

import jung.jwgg.domain.champ.AddCounterFormV2;
import jung.jwgg.domain.champ.Champ;
import jung.jwgg.web.champ.form.AddCounterDto;
import jung.jwgg.web.champ.form.AddCounterForm;
import jung.jwgg.web.champ.form.SearchCountDto;

import java.util.List;

public interface ChampRepository {
    List<Champ> recommendChamp(ChampRecoCond cond);

    Champ findChamp(String champName);

    Champ save(Champ champ);

    void counterSave(AddCounterDto addCounterDto);

    int dedupe(AddCounterDto addCounterDto);

    List<AddCounterFormV2> countedChamp(SearchCountDto searchCount);

    void deleteCounter(AddCounterDto addCounterDto);
}
