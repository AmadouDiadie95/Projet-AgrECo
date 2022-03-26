package daou.adama.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import daou.adama.entities.Produit;

// Extends JpaRepository fait herité l'interface de la classe interne de Spring qui va crée les methode CRUD automatiquement ,
// en indiquent la classe avec Produit et le Type de Id avec Long 
public interface ProduitsRepository extends JpaRepository<Produit, Long> {

}
