package ar.cpci.encuestasspring;

import ar.cpci.encuestasspring.model.Encuesta;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EncuestasSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(EncuestasSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EncuestaRepository repository) {
		return (args) -> {
			for (Integer i = 0; i < 10; ++i) {

				Encuesta s = new Encuesta();
				s.setNombre("encuesta" + i.toString());
				repository.save(s);

			}
		};
	}

}
