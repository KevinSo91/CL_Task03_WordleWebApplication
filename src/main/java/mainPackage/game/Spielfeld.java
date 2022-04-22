package mainPackage.game;

import org.springframework.beans.factory.annotation.Autowired;

public class Spielfeld {

	
	private int anzahlVersuche;
	
	private EingabeVersuch[] eingabeVersuche;
	
	
	@Autowired
	public Spielfeld(int anzahlVersuche, int anzahlBuchstaben) {
		
		this.anzahlVersuche = anzahlVersuche;
		this.eingabeVersuche = new EingabeVersuch[anzahlVersuche];
		for(EingabeVersuch ev : this.eingabeVersuche) {
			ev = new EingabeVersuch(anzahlBuchstaben);
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
