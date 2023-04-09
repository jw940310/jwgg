package jung.jwgg.web.champ.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCountDto {
    private Long loginId;
    private String SearchWord;
}
