package jung.jwgg.service.champ;

import jung.jwgg.domain.champ.Champ;

import java.util.List;

public interface ChampService {
    List<Champ> recommendChamp(Champ champ);

    Champ save(Champ champ);

    Champ findChamp(String champName);

}
