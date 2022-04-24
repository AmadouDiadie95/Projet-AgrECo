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
	public void run(String... args) throws Exception { // Methode qui s'execute deh le demarage de l'application avant tous le rest
		// TODO Auto-generated method stub
		
	}

}
