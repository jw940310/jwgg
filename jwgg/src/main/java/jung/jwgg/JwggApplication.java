package jung.jwgg;

import jung.jwgg.config.MemoryConfig;
import jung.jwgg.config.MyBatisConfig;
import jung.jwgg.repository.champ.ChampRepository;
import jung.jwgg.repository.item.ItemRepository;
import jung.jwgg.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Slf4j
//@Import({MemoryConfig.class,WebConfig.class})
@Import({MyBatisConfig.class,WebConfig.class})
@SpringBootApplication(scanBasePackages = {"jung.jwgg.web","jung.jwgg.service"})
public class JwggApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwggApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository, MemberRepository memberRepository, ChampRepository champRepository) {
		return new TestDataInit(itemRepository,memberRepository,champRepository);
	}
}
