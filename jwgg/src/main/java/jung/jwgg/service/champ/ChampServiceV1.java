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

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
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
    public String scrapeHeadToHeadWinRate(String championName1, String championName2) throws IOException {
        String url = "https://lolalytics.com/lol/" + championName1 + "/vs/" + championName2 + "/build/";
        Document doc = Jsoup.connect(url).get();
        String winRate = doc.select(".ChampionVsStats_stats__7sEQ- div div[1]").text();
        System.out.println("winRate = " + winRate);
        return winRate;
    }
/*
    @Override
    public void scrapeHeadToHeadWinRate(String championName1, String championName2) {
        String url = "https://lolalytics.com/lol/" + championName1 + "/vs/" + championName2 + "/build/";
        try {
            URLConnection connection = new URL(url).openConnection();
            InputStream inputStream = connection.getInputStream();
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
            XPath xpath = XPathFactory.newInstance().newXPath();
            String expression = "/html/body/div/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div/text()[1]"; // XPath 표현식
            String text = (String) xpath.evaluate(expression, doc, XPathConstants.STRING);
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
}