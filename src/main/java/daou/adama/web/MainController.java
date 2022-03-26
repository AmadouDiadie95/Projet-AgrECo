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
		model.addAttribute("newEnqueteur", newEnqueteur) ;
		return "enqueteur-ajouter" ;
	}
	
	@GetMapping("/liste-enqueteur")
	public String ListeEnqueter(Model model) {
		allEnqueteurs = enqueteursRepository.findAll() ;
		model.addAttribute("allEnqueteurs", allEnqueteurs) ;
		return "enqueteur-liste" ;
	}
	
	@PostMapping("enregistrer-enqueteur")
	public String saveEnqueteur(@ModelAttribute Enqueteur enqueteurReçu, Model model) {
		System.out.println(enqueteurReçu.toString());
		enqueteursRepository.save(enqueteurReçu) ;
		return ListeEnqueter(model) ;
	}
	
	@GetMapping("detail-enqueteur")
	public String detailEnqueteur(@RequestParam Long id, Model model) {
		enqueteurDetail = enqueteursRepository.findById(id).get() ;
		model.addAttribute("enqueteurDetail", enqueteurDetail) ;
		return "enqueteur-detail";
	}
	
	/*----------------------------------------------------*/
	
	@GetMapping("/ajouter-exploitant")
	public String AjouterExploitant() {
		return "exploitant-ajouter" ;
	}
	
	@GetMapping("/liste-exploitant")
	public String ListeExploitant() {
		return "exploitant-liste" ;
	}
	
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
