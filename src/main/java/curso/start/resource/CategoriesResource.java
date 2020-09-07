package curso.start.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.start.domain.Categorie;

@RestController 
@RequestMapping(value= "/categories") 
public class CategoriesResource {
	
	@GetMapping
	public HttpEntity<List> listar() {
		
		List<Categorie> projetos= new ArrayList();
		Categorie Informatica= new Categorie(1,"Informática");
		Categorie Mecanica= new Categorie(2,"Mecânica");
		projetos.add(Informatica);
		projetos.add(Mecanica);
		return new HttpEntity<List>(projetos);
	}
}
