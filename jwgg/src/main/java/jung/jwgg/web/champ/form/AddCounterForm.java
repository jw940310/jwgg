package jung.jwgg.web.champ.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddCounterForm {
    @NotBlank
    private String registerChampName;
    @NotBlank
    private String counter;
}
