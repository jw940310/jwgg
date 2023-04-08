package jung.jwgg.repository.member.mybatis;

import jung.jwgg.domain.member.Member;
import jung.jwgg.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MyBatisMemberRepository implements MemberRepository {

    private final MemberMapper memberMapper;

    @Override
    public Member save(Member member) {
        memberMapper.save(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return memberMapper.findByLoginId(loginId);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return memberMapper.findByName(name);
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public void clearStore() {

    }
}
