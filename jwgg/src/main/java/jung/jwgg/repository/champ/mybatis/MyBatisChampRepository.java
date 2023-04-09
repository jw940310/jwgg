package jung.jwgg.repository.champ.mybatis;

import jung.jwgg.domain.champ.AddCounterFormV2;
import jung.jwgg.domain.champ.Champ;
import jung.jwgg.repository.champ.ChampRecoCond;
import jung.jwgg.repository.champ.ChampRepository;
import jung.jwgg.web.champ.form.AddCounterDto;
import jung.jwgg.web.champ.form.AddCounterForm;
import jung.jwgg.web.champ.form.SearchCountDto;
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
    public void counterSave(AddCounterDto addCounterDto) {
        champMapper.counterSave(addCounterDto);
    }

    @Override
    public int dedupe(AddCounterDto addCounterDto) {
        return champMapper.dedupe(addCounterDto);
    }

    @Override
    public List<AddCounterFormV2> countedChamp(SearchCountDto searchCount) {
        return champMapper.countedChamp(searchCount);
    }

    @Override
    public void deleteCounter(AddCounterDto addCounterDto) {
        champMapper.deleteCounter(addCounterDto);
    }
}
