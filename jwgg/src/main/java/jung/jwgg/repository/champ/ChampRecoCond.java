package jung.jwgg.repository.champ;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChampRecoCond {
    private List<Integer> redTeam;

    private Long loginId;

    private Integer redChampId1;
    private String redChampName1;
    private Integer redChampId2;
    private String redChampName2;
    private Integer redChampId3;
    private String redChampName3;
    private Integer redChampId4;
    private String redChampName4;
    private Integer redChampId5;
    private String redChampName5;

    private Integer blueChampId1;
    private String blueChampName1;
    private Integer blueChampId2;
    private String blueChampName2;
    private Integer blueChampId3;
    private String blueChampName3;
    private Integer blueChampId4;
    private String blueChampName4;

    private String champLine;

    public List<String> getRedNames() {
        List<String> redNames = new ArrayList<String>();
        redNames.add(this.redChampName1);
        redNames.add(this.redChampName2);
        redNames.add(this.redChampName3);
        redNames.add(this.redChampName4);
        redNames.add(this.redChampName5);
        return redNames;
    }

//    public void addRedTeam(Integer redId) {
//        redTeam.add(redId);
//    }
}
