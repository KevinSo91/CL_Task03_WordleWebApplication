package mainPackage.wort;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WortRepository extends JpaRepository<Wort, Long>{

	@Query(value = "SELECT * FROM wortschatz_table WHERE sprache = ?1", nativeQuery = true)
	List<Wort> findeAlleWoerterAusSprache(String sprache);
	
	@Query(value = "SELECT * FROM wortschatz_table WHERE laenge = ?1", nativeQuery = true)
	List<Wort> findeAlleWoerterMitWortlaenge(int laenge);
	
	@Query(value = "SELECT * FROM wortschatz_table WHERE (sprache = ?1 AND laenge = ?2)", nativeQuery = true)
	List<Wort> findeAlleWoerterAusSpracheMitWortlaenge(String sprache, int laenge);

}
