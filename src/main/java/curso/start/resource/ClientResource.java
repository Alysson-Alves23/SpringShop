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

import curso.start.domain.Cliente;
import curso.start.service.ClienteService;
import curso.start.service.ClienteService;

@RestController 
@RequestMapping(value= "/Clientes") 
public class ClientResource {
	@Autowired 
	ClienteService service;
	
	@GetMapping(value = "/{id}" )
	public ResponseEntity<?> find(@PathVariable int id) {
		Cliente cli= service.findByid(id);
		if(cli != null) {
			return new ResponseEntity<>(cli, HttpStatus.OK);
					}else {
						return new ResponseEntity<>( HttpStatus.NOT_FOUND);
						}
					
	}
	@GetMapping
	public ResponseEntity<?> findAll(){
		
		List<Cliente> opt= new ArrayList<>();
		
		service.listAll().forEach(i -> opt.add(i));
				
		return new ResponseEntity<>(opt, HttpStatus.OK);
		}
				
	@PostMapping
	public ResponseEntity<?> create(@RequestParam Cliente cli){
		
		return new ResponseEntity<>(service.Create(cli), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		
		service.Delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
