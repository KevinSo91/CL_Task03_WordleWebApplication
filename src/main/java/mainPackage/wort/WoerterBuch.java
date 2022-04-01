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
			
			Wort wort0 = new Wort("Hund", "german");
			Wort wort1 = new Wort("Maus", "german");
			Wort wort2 = new Wort("Koala", "german");
			Wort wort3 = new Wort("luchs", "german");
			Wort wort4 = new Wort("fuchs", "german");
			Wort wort5 = new Wort("dachs", "german");
			Wort wort6 = new Wort("hippo", "english");
			Wort wort7 = new Wort("horse", "english");
			Wort wort8 = new Wort("chimp", "english");
			Wort wort9 = new Wort("snake", "english");
	
			
			repository.saveAll(List.of(wort0, wort1, wort2, wort3, wort4, wort5, wort6, wort7, wort8, wort9));
		};
	}

}
