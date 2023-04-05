package jung.jwgg.repository.item.mybatis;

import jung.jwgg.domain.item.Item;
import jung.jwgg.repository.item.ItemSearchCond;
import jung.jwgg.repository.item.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    void save(Item item);

    void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateParam);

    Item findById(Long id);

    List<Item> findAll(ItemSearchCond itemSearch);
}
