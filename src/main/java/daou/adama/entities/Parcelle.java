package daou.adama.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
//@Data de lombok genere automatiquement les getters, setters
//@@NoArgsConstructor de lombok genere automatiquement un contructeur sans arguments
//@@AllArgsConstructor de lombok genere automatiquement un contructeur avec arguments
public class Parcelle {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue dit a la Base de donnee de Auto-Increment l'atrribut Id
	private Long id ;
	private double superficie ;
	private String culture ;
	private String produit ;
	private String quantiteRecolte ;
	private String quantiteSemence ;
	private String etatSol ;
	private String nbreTravailleur ;
	private String coordonnees ;
}
