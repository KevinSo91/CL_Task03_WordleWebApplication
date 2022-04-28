package mainPackage.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Feld {
	
	private int id;
	
	private Character buchstabe;
	
	private String farbe;
	
	
	@Autowired
	public Feld() {
		this.farbe = "white";
	}	

	public Feld(int id) {
		this.id = id;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Character getBuchstabe() {
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
