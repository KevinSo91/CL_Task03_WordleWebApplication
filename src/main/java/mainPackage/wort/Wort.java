package mainPackage.wort;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "words_table")
public class Wort {
	
	// Attribute
	@Id
	@SequenceGenerator(
			name = "seq_wort",
			sequenceName = "seq_wort",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "seq_wort"
	)	
	private Long id;
	
	private String wort;
	
	private Integer laenge;
	
	private String sprache;
	
	
	public Wort() {		
	}
	
	// Konstruktoren
	public Wort(String wort) {
		this.wort = wort.toUpperCase();
		this.laenge = wort.length();
	}
	public Wort(String wort, String sprache) {
		this(wort);
		this.sprache = sprache;		
	}

	public String getWort() {
		return this.wort;
	}

	public void setWort(String wort) {
		this.wort = wort.toUpperCase();
		this.laenge = wort.length();
	}
	
	public int getLaenge() {
		return this.laenge;
	}

	public String getSprache() {
		return sprache;
	}

	public void setSprache(String sprache) {
		this.sprache = sprache;
	}

	
}
