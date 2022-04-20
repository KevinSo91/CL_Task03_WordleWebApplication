package mainPackage.wort;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WoerterBuch {
	
	@Bean
	CommandLineRunner commandLineRunner(WortRepository repository) {
		return args -> {
			
			Wort wort00 = new Wort("Hund", "german");
			Wort wort01 = new Wort("Maus", "german");
			Wort wort02 = new Wort("Koala", "german");
			Wort wort03 = new Wort("luchs", "german");
			Wort wort04 = new Wort("fuchs", "german");
			Wort wort05 = new Wort("dachs", "german");
			Wort wort06 = new Wort("hippo", "english");
			Wort wort07 = new Wort("horse", "english");
			Wort wort08 = new Wort("chimp", "english");
			Wort wort09 = new Wort("snake", "english");
			Wort wort10 = new Wort("Vogel", "german");
			Wort wort11 = new Wort("bird", "english");
			Wort wort12 = new Wort("Katze", "german");
			
			repository.saveAll(Arrays.asList(wort00, wort01, wort02, wort03, wort04, wort05, wort06, wort07, wort08, wort09, wort10, wort11, wort12));
		};
	}

}
