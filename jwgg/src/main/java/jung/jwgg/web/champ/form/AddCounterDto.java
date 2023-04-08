package jung.jwgg.web.champ.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCounterDto {
    private Long loginId;
    private Integer id;
    private Integer cid;
}
