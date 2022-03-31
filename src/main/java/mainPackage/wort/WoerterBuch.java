package mainPackage.wort;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WoerterBuch {
	
	@Bean
	CommandLineRunner commandLineRunner(WortRepository repository) {
		return args -> {
			
			Wort wort0 = new Wort("Hund", "deutsch");
			Wort wort1 = new Wort("Maus", "deutsch");
			Wort wort2 = new Wort("Koala", "deutsch");
			Wort wort3 = new Wort("luchs", "deutsch");
			Wort wort4 = new Wort("fuchs", "deutsch");
			Wort wort5 = new Wort("dachs", "deutsch");
			Wort wort6 = new Wort("hippo", "englisch");
			Wort wort7 = new Wort("horse", "englisch");
			Wort wort8 = new Wort("chimp", "englisch");
			Wort wort9 = new Wort("snake", "englisch");
	
			
			repository.saveAll(List.of(wort0, wort1, wort2, wort3, wort4, wort5, wort6, wort7, wort8, wort9));
		};
	}

}
