package mainPackage.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EingabeVersuch {
	
	private int id;
	
	private int anzahlBuchstaben;
	
	private Feld[] buchstabenFelder;
	
	@Autowired
	public EingabeVersuch() {
		this.buchstabenFelder = new Feld[anzahlBuchstaben];
	}
	

	public EingabeVersuch(int id, int anzahlBuchstaben) {
		this.id = id;
		this.buchstabenFelder = new Feld[anzahlBuchstaben];
		for(int i = 0; i < anzahlBuchstaben; i++) {
			int id_feld = Integer.parseInt(Integer.toString(this.id) + Integer.toString(i));			
			buchstabenFelder[i] = new Feld(id_feld);
		}
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Feld[] getBuchstabenFelder() {
		return buchstabenFelder;
	}


	public int getAnzahlBuchstaben() {
		return anzahlBuchstaben;
	}

	public void setAnzahlBuchstaben(int anzahlBuchstaben) {
		this.anzahlBuchstaben = anzahlBuchstaben;
	}

	public void setBuchstabenFelder(Feld[] buchstabenFelder) {
		this.buchstabenFelder = buchstabenFelder;
	}
	
	
	
	

}
