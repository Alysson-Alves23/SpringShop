package curso.start.repository;

import org.springframework.data.repository.CrudRepository;

import curso.start.domain.Categorie;
@org.springframework.stereotype.Repository
public interface RepositoryCat extends CrudRepository<Categorie,Integer>{
		

}
