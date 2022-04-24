package daou.adama.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaterielController {

	@GetMapping("/ajouter-materiel")
	public String Ajoutermateriel() {
		return "materiel-ajouter" ;
	}
	
	@GetMapping("/liste-materiel")
	public String Listemateriel() {
		return "materiel-liste" ;
	}
	
}
