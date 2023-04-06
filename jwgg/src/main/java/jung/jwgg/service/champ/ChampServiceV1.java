package jung.jwgg.service.champ;

import jung.jwgg.domain.champ.Champ;
import jung.jwgg.repository.champ.ChampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChampServiceV1 implements ChampService{

    private final ChampRepository champRepository;

    @Override
    public List<Champ> recommendChamp(Champ champ) {
        return champRepository.recommendChamp(champ);
    }

    @Override
    public Champ save(Champ champ) {
        return champRepository.save(champ);
    }

    @Override
    public Champ findChamp(String champName) {
        return champRepository.findChamp(champName);
    }
}
