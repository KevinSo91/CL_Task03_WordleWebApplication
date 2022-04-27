package mainPackage.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Feld {
	
	private int id;
	
	private char buchstabe;
	
	private String farbe;
	
	@Autowired
	public Feld() {
		this.farbe = "white";
	}
	
//	@Autowired
	public Feld(char buchstabe) {
		this.buchstabe = buchstabe;
		this.farbe = "white";
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
