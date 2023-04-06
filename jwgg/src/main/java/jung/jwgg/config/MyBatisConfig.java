package jung.jwgg.config;

import jung.jwgg.repository.champ.ChampRepository;
import jung.jwgg.repository.champ.mybatis.ChampMapper;
import jung.jwgg.repository.champ.mybatis.MyBatisChampRepository;
import jung.jwgg.repository.item.ItemRepository;
import jung.jwgg.repository.item.mybatis.ItemMapper;
import jung.jwgg.repository.item.mybatis.MyBatisItemRepository;
import jung.jwgg.repository.member.MemberRepository;
import jung.jwgg.repository.member.MemoryMemberRepository;
import jung.jwgg.repository.member.mybatis.MemberMapper;
import jung.jwgg.repository.member.mybatis.MyBatisMemberRepository;
import jung.jwgg.service.item.ItemService;
import jung.jwgg.service.item.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final ItemMapper itemMapper;
    private final MemberMapper memberMapper;
    private final ChampMapper champMapper;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MyBatisItemRepository(itemMapper);
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MyBatisMemberRepository(memberMapper);
    }

    @Bean
    public ChampRepository champRepository() {
        return new MyBatisChampRepository(champMapper);
    }
}
