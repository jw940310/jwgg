package jung.jwgg.config;

import jung.jwgg.repository.item.ItemRepository;
import jung.jwgg.repository.item.MemoryItemRepository;
import jung.jwgg.repository.member.MemberRepository;
import jung.jwgg.repository.member.MemoryMemberRepository;
import jung.jwgg.service.item.ItemService;
import jung.jwgg.service.item.ItemServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {
    @Bean
    public ItemRepository itemRepository() {
        return new MemoryItemRepository();
    }

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
