package mainPackage.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Feld {
	
	private int id;
	
	private String buchstabe;
	
	private String farbe;
	
	
	@Autowired
	public Feld() {
		this.farbe = "white";
	}	

	public Feld(int id) {
		this.farbe = "white";
		this.id = id;
		this.buchstabe = "";
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuchstabe() {
		return this.buchstabe;
	}

	public void setBuchstabe(String buchstabe) {
		this.buchstabe = buchstabe;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

}
