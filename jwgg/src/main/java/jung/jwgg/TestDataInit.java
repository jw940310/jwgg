package jung.jwgg;

import jung.jwgg.domain.champ.Champ;
import jung.jwgg.domain.item.Item;
import jung.jwgg.domain.member.Member;
import jung.jwgg.repository.champ.ChampRepository;
import jung.jwgg.repository.item.ItemRepository;
import jung.jwgg.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final ChampRepository champRepository;

    /*
        테스트용 데이터 추가
    */

//    @PostConstruct
    @EventListener(ApplicationReadyEvent.class) // AOP를 포함한 스프링 컨테이너가 완전히 초기화 된 이후에 호출되기 때문에 문제 발생X
    public void init() {

//        itemRepository.save(new Item("itemA", 10000, 10));
//        itemRepository.save(new Item("itemB", 20000, 20));

        if (memberRepository.findByLoginId("test").isEmpty()) {
            Member member = new Member();
            member.setLoginId("test");
            member.setPassword("test!");
            member.setName("테스터");
            memberRepository.save(member);
        }
    }

    public void addChamp(String champName, String champLine) {
        if (champRepository.findChamp(champName) == null) {
            Champ newChamp = new Champ(champName,champLine);
            champRepository.save(newChamp);
        }
    }
}
