package py.com.nsa.cortesia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CortesiaApplication {
	private static final Logger logger = LoggerFactory.getLogger(CortesiaApplication.class);

	public static void main(String[] args) {

		logger.info("<=== Iniciando {} ... ===>", CortesiaApplication.class.getName());
		SpringApplication.run(CortesiaApplication.class, args);
		logger.info("<=== {} Iniciado correctamente ===>", CortesiaApplication.class.getName());
	}

}
