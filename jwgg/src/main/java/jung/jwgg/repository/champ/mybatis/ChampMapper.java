package jung.jwgg.repository.champ.mybatis;

import jung.jwgg.domain.champ.AddCounterFormV2;
import jung.jwgg.domain.champ.Champ;
import jung.jwgg.repository.champ.ChampRecoCond;
import jung.jwgg.web.champ.form.AddCounterDto;
import jung.jwgg.web.champ.form.AddCounterForm;
import jung.jwgg.web.champ.form.SearchCountDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChampMapper {
    List<Champ> recommendChamp(ChampRecoCond cond);

    void save(Champ champ);

    Champ findChamp(String champName);

    void counterSave(AddCounterDto addCounterDto);

    int dedupe(AddCounterDto addCounterDto);

    List<AddCounterFormV2> countedChamp(SearchCountDto searchCount);

    void deleteCounter(AddCounterDto addCounterDto);
}
