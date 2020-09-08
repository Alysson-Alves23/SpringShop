package curso.start.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.start.domain.Categorie;
import curso.start.repository.RepositoryCat;
import curso.start.service.exceptions.ObjectNotFoundException;
@Service
public class CategorieService {
	
	@Autowired
	RepositoryCat repo;
	
	public Categorie findByid(int id) throws ObjectNotFoundException{
			
		Optional<Categorie> cat= repo.findById(id);
		if(!cat.isEmpty()) { 
		 return cat.orElse(null);
		 }else {throw  new ObjectNotFoundException("Id "+id+" não encontrado"); }
		
	}
	

	public Categorie Create(Categorie cat) {
		boolean status;
		
		Categorie p=repo.save(cat);
		
		return p;
	}
	public void Delete(int id) {
		
		repo.deleteById(id);
		
	};
	public Iterable<Categorie> listAll(){
	 
		return repo.findAll();
	}

}
