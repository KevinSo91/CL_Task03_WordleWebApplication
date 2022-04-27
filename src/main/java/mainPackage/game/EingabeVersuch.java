package mainPackage.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EingabeVersuch {
	
	
	private int anzahlBuchstaben;
	
	private Feld[] buchstabenFelder;
	
	@Autowired
	public EingabeVersuch() {
		this.buchstabenFelder = new Feld[anzahlBuchstaben];
	}
	
//	@Autowired
	public EingabeVersuch(int anzahlBuchstaben) {
		this.buchstabenFelder = new Feld[anzahlBuchstaben];
		for(int i = 0; i < anzahlBuchstaben; i++) {
			buchstabenFelder[i] = new Feld();
		}
	}


	public Feld[] getBuchstabenFelder() {
		return buchstabenFelder;
	}


	public void setBuchstabenFelder(Feld[] buchstabenFelder) {
		this.buchstabenFelder = buchstabenFelder;
	}
	
	
	
	

}
