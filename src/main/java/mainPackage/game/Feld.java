package mainPackage.game;

public class Feld {
	
	private char buchstabe;
	
	private String farbe;
	
	
	public Feld() {		
	}
	
	public Feld(char buchstabe) {
		this.buchstabe = buchstabe;
		this.farbe = "white";
	}
	
	

	public char getBuchstabe() {
		return buchstabe;
	}

	public void setBuchstabe(char buchstabe) {
		this.buchstabe = buchstabe;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

}
