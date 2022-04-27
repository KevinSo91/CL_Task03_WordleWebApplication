package mainPackage.wort;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WortService {

	@Autowired
	private final WortRepository wortRepository; 

	@Autowired
	public WortService(WortRepository wortRepository) {
		this.wortRepository = wortRepository;
	}

	// Methode zum Anzeigen aller Wörter
	public List<Wort> findeAlleWoerter(){
		return wortRepository.findAll();
	}
	
	public List<Wort> findeAlleWoerterAusSprache(String sprache) {
		return wortRepository.findeAlleWoerterAusSprache(sprache);
	}
	
	public List<Wort> findeAlleWoerterMitWortlaenge(int laenge) {
		return wortRepository.findeAlleWoerterMitWortlaenge(laenge);
	}
	
	public List<Wort> findeAlleWoerterAusSpracheMitWortlaenge(String sprache, int laenge) {
		return wortRepository.findeAlleWoerterAusSpracheMitWortlaenge(sprache, laenge);
	}
	
	
	public String findeZufallsWort() {
		long anzahlWoerter = findeAlleWoerter().size();
		Random zufalls = new Random();
		int zufallsZahl = zufalls.nextInt((int) anzahlWoerter);
		return findeAlleWoerter().get(zufallsZahl).getWort();
	}
	
	public String findeZufallsWortAusSprache(String sprache) {
		long anzahlWoerter = findeAlleWoerterAusSprache(sprache).size();
		Random zufalls = new Random();
		int zufallsZahl = zufalls.nextInt((int) anzahlWoerter);
		return findeAlleWoerterAusSprache(sprache).get(zufallsZahl).getWort();
	}
	
	public String findeZufallsWortMitWortlaenge(int laenge) {
		long anzahlWoerter = findeAlleWoerterMitWortlaenge(laenge).size();
		Random zufalls = new Random();
		int zufallsZahl = zufalls.nextInt((int) anzahlWoerter);
		return findeAlleWoerterMitWortlaenge(laenge).get(zufallsZahl).getWort();
	}
	
	public String findeZufallsWortAusSpracheMitWortlaenge(String sprache, int laenge) {
		long anzahlWoerter = findeAlleWoerterAusSpracheMitWortlaenge(sprache, laenge).size();
		Random zufalls = new Random();
		int zufallsZahl = zufalls.nextInt((int) anzahlWoerter);
		return findeAlleWoerterAusSpracheMitWortlaenge(sprache, laenge).get(zufallsZahl).getWort();
	}
	
	
	public void speichereNeuesWort(Wort neuesWort) {
		wortRepository.save(neuesWort);
	}
	
	public void loescheAltesWort(String altesWort) {		
		wortRepository.loescheWort(altesWort.toUpperCase());;
	}
	
}
