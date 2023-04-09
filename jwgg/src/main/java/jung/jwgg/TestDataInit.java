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
//    @EventListener(ApplicationReadyEvent.class) // AOP를 포함한 스프링 컨테이너가 완전히 초기화 된 이후에 호출되기 때문에 문제 발생X
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
        addChamp("가렌","탑");
        addChamp("갈리오","미드");
        addChamp("갱플랭크", "탑");
        addChamp("그라가스", "정글");
        addChamp("그레이브즈", "정글");
        addChamp("그웬", "탑");
        addChamp("나르", "탑");
        addChamp("나미", "서폿");
        addChamp("나서스", "탑");
        addChamp("노틸러스", "서폿");
        addChamp("녹턴", "정글");
        addChamp("누누", "정글");
        addChamp("니달리", "정글");
        addChamp("니코", "미드");
        addChamp("닐라", "원딜");
        addChamp("다리우스", "탑");
        addChamp("다이애나", "정글");
        addChamp("드레이븐", "정글");
        addChamp("라이즈", "미드");
        addChamp("라칸", "서폿");
        addChamp("람머스", "정글");
        addChamp("럭스", "서폿");
        addChamp("럼블", "탑");
        addChamp("레나타", "서폿");
        addChamp("레텍톤", "탑");
        addChamp("레오나", "서폿");
        addChamp("렉사이", "정글");
        addChamp("렐", "서폿");
        addChamp("렝가", "정글");
        addChamp("루시안", "원딜");
        addChamp("룰루", "서폿");
        addChamp("르블랑", "미드");
        addChamp("리신", "정글");
        addChamp("리븐", "탑");
        addChamp("리산드라", "미드");
        addChamp("릴리아", "정글");
        addChamp("마스터이", "정글");
        addChamp("마오카이", "정글");
        addChamp("말자하", "미드");
        addChamp("말파이트", "탑");
        addChamp("모데카이저", "탑");
        addChamp("모르가나", "탑");
        addChamp("문도", "탑");
        addChamp("미스포츈", "원딜");
        addChamp("밀리오", "탑");
        addChamp("바드", "탑");
        addChamp("바루스", "원딜");
        addChamp("바이", "탑");
        addChamp("베이가", "탑");
        addChamp("베인", "원딜");
        addChamp("벡스", "탑");
        addChamp("벨베스", "탑");
        addChamp("벨코즈", "탑");
        addChamp("볼리베어", "탑");
        addChamp("브라움", "탑");
        addChamp("브랜드", "탑");
        addChamp("블라디미르", "탑");
        addChamp("블리츠크랭크", "탑");
        addChamp("비에고", "탑");
        addChamp("빅토르", "탑");
        addChamp("뽀삐", "탑");
        addChamp("사미라", "원딜");
        addChamp("사이온", "탑");
        addChamp("사일러스", "탑");
        addChamp("샤코", "탑");
        addChamp("세나", "탑");
        addChamp("세라핀", "탑");
        addChamp("세주아니", "탑");
        addChamp("세트", "탑");
        addChamp("소나", "탑");
        addChamp("소라카", "탑");
        addChamp("쉔", "탑");
        addChamp("쉬바나", "탑");
        addChamp("스웨인", "탑");
        addChamp("스카너", "탑");
        addChamp("시비르", "원딜");
        addChamp("신짜오", "탑");
        addChamp("신드라", "탑");
        addChamp("신지드", "탑");
        addChamp("쓰레쉬", "탑");
        addChamp("아리", "탑");
        addChamp("아무무", "탑");
        addChamp("아우렐리온솔", "탑");
        addChamp("아이번", "탑");
        addChamp("아지르", "탑");
        addChamp("아칼리", "탑");
        addChamp("아크샨", "탑");
        addChamp("아트록스", "탑");
        addChamp("아펠리오스", "원딜");
        addChamp("알리스타", "탑");
        addChamp("애니", "탑");
        addChamp("애니비아", "탑");
        addChamp("애쉬", "원딜");
        addChamp("야스오", "탑");
        addChamp("에코", "탑");
        addChamp("엘리스", "탑");
        addChamp("오공", "탑");
        addChamp("오른", "탑");
        addChamp("오리아나", "탑");
        addChamp("올라프", "탑");
        addChamp("요네", "탑");
        addChamp("요릭", "탑");
        addChamp("우디르", "탑");
        addChamp("우르곳", "탑");
        addChamp("워윅", "탑");
        addChamp("유미", "탑");
        addChamp("이렐리아", "탑");
        addChamp("이블린", "탑");
        addChamp("이즈리얼", "원딜");
        addChamp("일라오이", "탑");
        addChamp("자르반", "탑");
        addChamp("자야", "원딜");
        addChamp("자이라", "탑");
        addChamp("자크", "탑");
        addChamp("잔나", "탑");
        addChamp("잔나", "탑");
        addChamp("잭스", "탑");
        addChamp("제드", "탑");
        addChamp("제라스", "탑");
        addChamp("제리", "원딜");
        addChamp("제이스", "탑");
        addChamp("조이", "탑");
        addChamp("직스", "탑");
        addChamp("진", "원딜");
        addChamp("질리언", "서폿");
        addChamp("징크스", "원딜");
        addChamp("초가스", "탑");
        addChamp("카르마", "탑");
        addChamp("카밀", "탑");
        addChamp("카사딘", "탑");
        addChamp("카서스", "탑");
        addChamp("카시오페이아", "탑");
        addChamp("카이사", "원딜");
        addChamp("카직스", "탑");
        addChamp("카타리나", "미드");
        addChamp("칼리스타", "원딜");
        addChamp("케넨", "탑");
        addChamp("케이틀린", "원딜");
        addChamp("케인", "탑");
        addChamp("케일", "탑");
        addChamp("코그모", "원딜");
        addChamp("코르키", "탑");
        addChamp("퀸", "탑");
        addChamp("크샨테", "탑");
        addChamp("클레드", "탑");
        addChamp("키아나", "탑");
        addChamp("킨드레드", "탑");
        addChamp("타릭", "탑");
        addChamp("탈론", "탑");
        addChamp("탈리야", "탑");
        addChamp("탐켄치", "탑");
        addChamp("트런들", "탑");
        addChamp("트리스타나", "원딜");
        addChamp("트린다미어", "탑");
        addChamp("트위스티드페이트", "탑");
        addChamp("트위치", "원딜");
        addChamp("티모", "탑");
        addChamp("파이크", "탑");
        addChamp("판테온", "탑");
        addChamp("피들스틱", "탑");
        addChamp("피오라", "탑");
        addChamp("피즈", "탑");
        addChamp("하이머딩거", "탑");
        addChamp("헤카림", "탑");
    }

    public void addChamp(String champName, String champLine) {
        if (champRepository.findChamp(champName) == null) {
            Champ newChamp = new Champ(champName,champLine);
            champRepository.save(newChamp);
        }
    }
}
