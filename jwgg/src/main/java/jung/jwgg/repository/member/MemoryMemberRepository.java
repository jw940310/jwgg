package jung.jwgg.repository.member;

import jung.jwgg.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // static 사용(ConcurrentHashMap-동시성문제)
    private static long sequense = 0L; // static 사용(어텀long-동시성문제)

    @Override
    public Member save(Member member) {
        member.setId(++sequense);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Optional<Member> findByLoginId(String loginId) {
/*
        List<Member> all = findAll();
        for (Member m : all) {
            if (m.getLoginId().equals(loginId)) {
                return Optional.of(m);
            }
        }
        return Optional.empty();
*/

        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
