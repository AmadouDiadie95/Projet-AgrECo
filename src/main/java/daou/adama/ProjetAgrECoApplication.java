package daou.adama;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import daou.adama.entities.Produit;
import daou.adama.entities.repositories.ProduitsRepository;

@SpringBootApplication
public class ProjetAgrECoApplication implements CommandLineRunner {
	@Autowired	// Permet de creer une instance de l'interface sans avoir a ecrire de class de cette interface 
	ProduitsRepository produitsRepository ; 

	public static void main(String[] args) {
		SpringApplication.run(ProjetAgrECoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("************************** START *****************************");
		Produit p1 = new Produit() ;
		p1.setNom("fatala");
		p1.setType("insecticide");
		
		Produit p2 = new Produit() ;
		p2.setNom("Nido");
		p2.setType("Engrais");
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		produitsRepository.save(p1) ;
		produitsRepository.save(p2) ;
	}

}
