package jung.jwgg.repository.member;

import jung.jwgg.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByLoginId(String loginId);

    Optional<Member> findByName(String name);

    List<Member> findAll();

    void clearStore();
}
