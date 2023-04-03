package jung.jwgg.config;

import jung.jwgg.repository.item.ItemRepository;
import jung.jwgg.repository.item.MemoryItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {
    @Bean
    public ItemRepository itemRepository() {
        return new MemoryItemRepository();
    }
}
