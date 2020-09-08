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
	public ResponseEntity<Categorie> find(@PathVariable int id) {
		
		
		return new ResponseEntity<Categorie>(service.findByid(id),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List> findAll(){
		
		List<Categorie> opt= new ArrayList<Categorie>();
				service.listAll().forEach(i -> opt.add(i));
		
		return new ResponseEntity<List>(opt, HttpStatus.OK);
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
