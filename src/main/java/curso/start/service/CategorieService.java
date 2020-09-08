package curso.start.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.start.domain.Categorie;
import curso.start.repository.RepositoryCat;

@Service
public class CategorieService {
	
	@Autowired
	RepositoryCat repo;
	
	public Categorie findByid(int id) {
		 Optional<Categorie> cat= repo.findById(id);
		 
		 return cat.orElse(null);	
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
