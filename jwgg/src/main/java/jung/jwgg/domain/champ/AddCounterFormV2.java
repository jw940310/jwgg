package jung.jwgg.domain.champ;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddCounterFormV2 {
    private String registerChampName;
    private String counter;
    private String searchChamp;
}
