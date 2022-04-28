package mainPackage.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Spielfeld {

	
	private int anzahlVersuche;
	
	private EingabeVersuch[] eingabeVersuche;
	
	@Autowired
	public Spielfeld() {
		
	}
	
	public Spielfeld(int anzahlVersuche, int anzahlBuchstaben) {
		
		this.anzahlVersuche = anzahlVersuche;
		this.eingabeVersuche = new EingabeVersuch[anzahlVersuche];
		for(int i = 0; i < anzahlVersuche; i++) {
			eingabeVersuche[i] = new EingabeVersuch(i, anzahlBuchstaben);
		}
	}


	public int getAnzahlVersuche() {
		return anzahlVersuche;
	}



	public void setAnzahlVersuche(int anzahlVersuche) {
		this.anzahlVersuche = anzahlVersuche;
	}



	public EingabeVersuch[] getEingabeVersuche() {
		return eingabeVersuche;
	}



	public void setEingabeVersuche(EingabeVersuch[] eingabeVersuche) {
		this.eingabeVersuche = eingabeVersuche;
	}


	
	
	
}
