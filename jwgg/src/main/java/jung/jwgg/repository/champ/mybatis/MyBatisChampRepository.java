package jung.jwgg.repository.champ.mybatis;

import jung.jwgg.domain.champ.Champ;
import jung.jwgg.repository.champ.ChampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyBatisChampRepository implements ChampRepository {

    private final ChampMapper champMapper;

    @Override
    public List<Champ> recommendChamp(Champ champ) {
        return champMapper.recommendChamp(champ);
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
}
