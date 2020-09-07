package curso.start.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(value= "/project_list") 
public class CategoriaResource {
	
	@GetMapping
	public HttpEntity<List> listar() {
		
		List projetos= new ArrayList();
		projetos.add("Aula 14");
		return new HttpEntity<List>(projetos);
	}
}
