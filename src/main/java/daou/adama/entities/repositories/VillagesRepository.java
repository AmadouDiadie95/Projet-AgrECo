package daou.adama.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import daou.adama.entities.Utilisateur;

// Extends JpaRepository fait herité l'interface de la classe interne de Spring qui va crée les methode CRUD automatiquement ,
// en indiquent la classe avec Utilisateur et le Type de Id avec Long 
public interface VillagesRepository extends JpaRepository<Utilisateur, Long> {

}
