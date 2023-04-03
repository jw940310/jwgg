package jung.jwgg;

import jung.jwgg.config.MemoryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(MemoryConfig.class)
@SpringBootApplication
public class JwggApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwggApplication.class, args);
	}

}
