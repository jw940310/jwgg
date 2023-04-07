package jung.jwgg.repository.champ.mybatis;

import jung.jwgg.domain.champ.Champ;
import jung.jwgg.repository.champ.ChampRecoCond;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChampMapper {
    List<Champ> recommendChamp(ChampRecoCond cond);

    void save(Champ champ);

    Champ findChamp(String champName);

    void counterSave(@Param("id") Integer id, @Param("cid") Integer cid);

    int dedupe(@Param("id") Integer id, @Param("cid") Integer cid);
}
