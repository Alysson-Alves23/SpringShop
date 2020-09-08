package curso.start.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.start.domain.Categorie;
import curso.start.service.CategorieService;

@RestController 
@RequestMapping(value= "/categories") 
public class CategoriesResource {
	@Autowired 
	CategorieService service;
	
	@GetMapping(value = "/{id}" )
	public ResponseEntity<?> find(@PathVariable int id) {
		Categorie cat= service.findByid(id);
		if(cat != null) {
			return new ResponseEntity<>(cat, HttpStatus.OK);
					}else {
						return new ResponseEntity<>( HttpStatus.NOT_FOUND);
						}
					
	}
	@GetMapping
	public ResponseEntity<?> findAll(){
		
		List<Categorie> opt= new ArrayList<>();
		Iterable<Categorie> opc= service.listAll();
		opc.forEach(i -> opt.add(i));
				if(!(opt.isEmpty())) {
		return new ResponseEntity<>(opt, HttpStatus.OK);
				}else {
					return new ResponseEntity<>( HttpStatus.NOT_FOUND);
					}
				}
	@PostMapping
	public ResponseEntity<?> create(@RequestParam Categorie cat){
		
		return new ResponseEntity<>(service.Create(cat), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		
		service.Delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
