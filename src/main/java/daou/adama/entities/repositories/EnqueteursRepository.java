package daou.adama.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import daou.adama.entities.Enqueteur;

// Extends JpaRepository fait herité l'interface de la classe interne de Spring qui va crée les methode CRUD automatiquement ,
// en indiquent la classe avec Enqueteur et le Type de Id avec Long 
public interface EnqueteursRepository extends JpaRepository<Enqueteur, Long> {

}
