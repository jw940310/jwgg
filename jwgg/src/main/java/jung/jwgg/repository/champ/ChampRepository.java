package jung.jwgg.repository.champ;

import jung.jwgg.domain.champ.Champ;

import java.util.List;

public interface ChampRepository {
    List<Champ> recommendChamp(ChampRecoCond cond);

    Champ findChamp(String champName);

    Champ save(Champ champ);

    void counterSave(Integer id, Integer cid);

    int dedupe(Integer id, Integer cid);
}
