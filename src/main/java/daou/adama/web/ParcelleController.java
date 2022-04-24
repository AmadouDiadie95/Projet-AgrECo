package daou.adama.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParcelleController {

	@GetMapping("/ajouter-parcelle")
	public String Ajouterparcelle() {
		return "parcelle-ajouter" ;
	}
	
	@GetMapping("/liste-parcelle")
	public String Listeparcelle() {
		return "parcelle-liste" ;
	}
	
}
