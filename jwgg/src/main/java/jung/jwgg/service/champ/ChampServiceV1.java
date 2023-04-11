package jung.jwgg.service.champ;

import jung.jwgg.domain.champ.AddCounterFormV2;
import jung.jwgg.domain.champ.Champ;
import jung.jwgg.repository.champ.ChampRecoCond;
import jung.jwgg.repository.champ.ChampRepository;
import jung.jwgg.web.champ.form.AddCounterDto;
import jung.jwgg.web.champ.form.SearchCountDto;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChampServiceV1 implements ChampService{

    private final ChampRepository champRepository;

    @Override
    public List<Champ> recommendChamp(ChampRecoCond cond) {
        return champRepository.recommendChamp(cond);
    }

    @Override
    public Champ save(Champ champ) {
        return champRepository.save(champ);
    }

    @Override
    public Champ findChamp(String champName) {
        return champRepository.findChamp(champName);
    }

    @Override
    public void counterSave(AddCounterDto addCounterDto) {
        champRepository.counterSave(addCounterDto);
    }

    @Override
    public int dedupe(AddCounterDto addCounterDto) {
        return champRepository.dedupe(addCounterDto);
    }

    @Override
    public List<AddCounterFormV2> countedChamp(SearchCountDto searchCount) {
        return champRepository.countedChamp(searchCount);
    }
    @Override
    public void deleteCounter(AddCounterDto addCounterDto) {
        champRepository.deleteCounter(addCounterDto);
    }

    @Override
    public String scrapeHeadToHeadWinRate(String championName1, String championName2, String championLine) throws IOException {
        String url = "https://fow.kr/stats/" + championName1 + "/"+championLine+"/13.7/" + championName2;

        Document doc = Jsoup.connect(url).get();
        String myString = doc.select(".position_selected").text();
        int lastSpace = myString.lastIndexOf(" "); // 마지막 공백의 인덱스를 찾음
        String winRate = myString.substring(lastSpace+1);
        System.out.println("winRate = " + winRate);
        return winRate;
    }
}