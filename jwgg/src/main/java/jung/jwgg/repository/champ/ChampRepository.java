package jung.jwgg.repository.champ;

import jung.jwgg.domain.champ.Champ;
import jung.jwgg.web.champ.form.AddCounterDto;

import java.util.List;

public interface ChampRepository {
    List<Champ> recommendChamp(ChampRecoCond cond);

    Champ findChamp(String champName);

    Champ save(Champ champ);

    void counterSave(AddCounterDto addCounterDto);

    int dedupe(AddCounterDto addCounterDto);
}
