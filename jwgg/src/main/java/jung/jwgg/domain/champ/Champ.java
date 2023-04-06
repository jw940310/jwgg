package jung.jwgg.domain.champ;

import lombok.Data;

@Data
public class Champ {
    private Integer champId;
    private String champName;
    private String champLine;

    public Champ() {

    }

    public Champ(String champName, String champLine) {
        this.champName = champName;
        this.champLine = champLine;
    }
}
