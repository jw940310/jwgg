package jung.jwgg.repository.champ.mybatis;

import jung.jwgg.domain.champ.Champ;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChampMapper {
    List<Champ> recommendChamp(Champ champ);

    void save(Champ champ);

    Champ findChamp(String champName);

}
