package jung.jwgg.repository.item;

import jung.jwgg.domain.item.Item;

import java.util.List;

public interface ItemRepository {
    Item save(Item item);

    Item findById(Long id);

    List<Item> findAll();

    void update(Long itemId, Item updateParam);

    void clearStore();
}
