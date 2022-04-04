package daou.adama.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import daou.adama.entities.Enqueteur;
import daou.adama.entities.repositories.EnqueteursRepository;

@Controller
public class MainController {
	
	@Autowired
	EnqueteursRepository enqueteursRepository ;
	Enqueteur newEnqueteur = new Enqueteur() ;
	Enqueteur enqueteurDetail ;
	List<Enqueteur> allEnqueteurs = new ArrayList<Enqueteur>() ;
	
	@GetMapping("")
	public String home() {
		return "index" ;
	}
	
	/*----------------------------------------------------*/
	
	@GetMapping("/ajouter-enqueteur") // Permet d'appeler la methode suivante lors de l'url suivante : localhost:8888/ajouter-enqueteur
	public String AjouterEnqueter(Model model) {
		newEnqueteur = new Enqueteur() ;
		model.addAttribute("newEnqueteur", newEnqueteur) ;
		return "enqueteur-ajouter" ;
	}
	
	@GetMapping("/liste-enqueteur")
	public String ListeEnqueter(Model model) {
		allEnqueteurs = enqueteursRepository.findAll() ; // Recupere tous les enqueteurs dans la base de données 
		model.addAttribute("allEnqueteurs", allEnqueteurs) ; // Envoie les enqueteir recuperé de la BD vers le html "enqueteur-liste.html"
		return "enqueteur-liste" ;
	}
	
	@PostMapping("enregistrer-enqueteur")
	public String saveEnqueteur(@ModelAttribute Enqueteur enqueteurReçu, Model model) {
		System.out.println(enqueteurReçu.toString()); 
		enqueteursRepository.save(enqueteurReçu) ; // Permet de sauvegarder dans la base de donnees, table enqueteur
		return ListeEnqueter(model) ;
	}
	
	@GetMapping("detail-enqueteur")
	public String detailEnqueteur(@RequestParam Long id, Model model) {
		enqueteurDetail = enqueteursRepository.findById(id).get() ; // Permet de faire comme en SQL : select * from enqueteur where id=id
		model.addAttribute("enqueteurDetail", enqueteurDetail) ; // On envoie l'object enqueteur dans le html "enqueteur-detail.html"
		return "enqueteur-detail";
	}
	
	@GetMapping("modifier-enqueteur") 
	public String modifier(Model model) {
		model.addAttribute("newEnqueteur", enqueteurDetail) ;
		return "enqueteur-modifier" ;
	}
	
	@PostMapping("update-enqueteur")
	public String updateEnqueteur(@ModelAttribute Enqueteur enqueteurReçu, Model model, @RequestParam Long id) {
		enqueteurReçu.setId(id);
		enqueteursRepository.save(enqueteurReçu) ; // Permet de sauvegarder dans la base de donnees, table enqueteur
		return ListeEnqueter(model) ;
	}
	
	@GetMapping("supprimer-enqueteur")
	public String deleteEnqueteur(Model model) {
		enqueteursRepository.delete(enqueteurDetail);
		return ListeEnqueter(model) ; // Appel la methode/fonction qui affiche la liste des enqueteurs dans le html
	}

	
	/*----------------------------------------------------*/
	
	
	/*----------------------------------------------------*/
	
	@GetMapping("/ajouter-materiel")
	public String Ajoutermateriel() {
		return "materiel-ajouter" ;
	}
	
	@GetMapping("/liste-materiel")
	public String Listemateriel() {
		return "materiel-liste" ;
	}
	
	/*----------------------------------------------------*/
	
	@GetMapping("/ajouter-parcelle")
	public String Ajouterparcelle() {
		return "parcelle-ajouter" ;
	}
	
	@GetMapping("/liste-parcelle")
	public String Listeparcelle() {
		return "parcelle-liste" ;
	}
	
	/*----------------------------------------------------*/
	
	@GetMapping("/ajouter-produit")
	public String Ajouterproduit() {
		return "produit-ajouter" ;
	}
	
	@GetMapping("/liste-produit")
	public String Listeproduit() {
		return "produit-liste" ;
	}
	
	/*----------------------------------------------------*/
	
	@GetMapping("/ajouter-village")
	public String Ajoutervillage() {
		return "village-ajouter" ;
	}
	
	@GetMapping("/liste-village")
	public String Listevillage() {
		return "village-liste" ;
	}
	
	/*----------------------------------------------------*/


}
