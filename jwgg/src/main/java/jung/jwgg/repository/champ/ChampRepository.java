package jung.jwgg.repository.champ;

import jung.jwgg.domain.champ.Champ;

import java.util.List;

public interface ChampRepository {
    List<Champ> recommendChamp(Champ champ);

    Champ findChamp(String champName);

    Champ save(Champ champ);

}
