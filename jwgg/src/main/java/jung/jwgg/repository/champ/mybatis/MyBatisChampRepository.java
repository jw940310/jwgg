package jung.jwgg.repository.champ.mybatis;

import jung.jwgg.domain.champ.Champ;
import jung.jwgg.repository.champ.ChampRecoCond;
import jung.jwgg.repository.champ.ChampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyBatisChampRepository implements ChampRepository {

    private final ChampMapper champMapper;

    @Override
    public List<Champ> recommendChamp(ChampRecoCond cond) {
        return champMapper.recommendChamp(cond);
    }

    @Override
    public Champ findChamp(String champName) {
        return champMapper.findChamp(champName);
    }

    @Override
    public Champ save(Champ champ) {
        champMapper.save(champ);
        return champ;
    }

    @Override
    public void counterSave(Integer id, Integer cid) {
        champMapper.counterSave(id,cid);
    }

    @Override
    public int dedupe(Integer id, Integer cid) {
        return champMapper.dedupe(id,cid);
    }
}
