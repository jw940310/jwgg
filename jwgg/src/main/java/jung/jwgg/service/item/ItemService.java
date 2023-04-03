package jung.jwgg.service.item;

import jung.jwgg.domain.item.Item;
import jung.jwgg.repository.item.ItemSearchCond;
import jung.jwgg.repository.item.ItemUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Item findById(Long id);

    List<Item> findItems(ItemSearchCond itemSearch);

}
