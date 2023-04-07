package jung.jwgg.service.champ;

import jung.jwgg.domain.champ.Champ;
import jung.jwgg.repository.champ.ChampRecoCond;
import jung.jwgg.repository.champ.ChampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChampServiceV1 implements ChampService{

    private final ChampRepository champRepository;

    @Override
    public List<Champ> recommendChamp(ChampRecoCond cond) {
        return champRepository.recommendChamp(cond);
    }

    @Override
    public Champ save(Champ champ) {
        return champRepository.save(champ);
    }

    @Override
    public Champ findChamp(String champName) {
        return champRepository.findChamp(champName);
    }

    @Override
    public void counterSave(Integer id, Integer cid) {
        champRepository.counterSave(id,cid);
    }

    @Override
    public int dedupe(Integer id, Integer cid) {
        return champRepository.dedupe(id,cid);
    }
}
