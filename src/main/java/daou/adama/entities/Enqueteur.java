package daou.adama.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
//@Data de lombok genere automatiquement les getters, setters
//@NoArgsConstructor de lombok genere automatiquement un contructeur sans arguments
//@AllArgsConstructor de lombok genere automatiquement un contructeur avec arguments
public class Enqueteur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // GeneratedValue dit a la Base de donnee de Auto-Increment l'atrribut Id 
	private Long id ;
	private String nom ;
	private String prenom ;
	private String adresse ;
	private int age ;
	private String telephone ;
	
	@Lob // @Lob Indique a spring data que c'est un attribut qui contient enormement caractere
	private String image;
	
	
	@Lob @Transient // @Transcient indique que cet attribut n'est pas persister, donc pas de colonne dans la table 
	private MultipartFile file ;

}
