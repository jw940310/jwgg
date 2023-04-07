package jung.jwgg.service.champ;

import jung.jwgg.domain.champ.Champ;
import jung.jwgg.repository.champ.ChampRecoCond;

import java.util.List;

public interface ChampService {
    List<Champ> recommendChamp(ChampRecoCond cond);

    Champ save(Champ champ);

    Champ findChamp(String champName);

    void counterSave(Integer id, Integer cid);

    int dedupe(Integer id, Integer cid);

}
