package jung.jwgg.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Member {

    private Long id;

    @NotEmpty
    private String loginId; // 로그인 ID
    @NotEmpty
    private String name; // 사용자 이름
    @Size(min = 8,max = 12)
    private String password;
}
