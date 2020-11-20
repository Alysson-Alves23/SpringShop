package curso.start.repository;

import org.springframework.data.repository.CrudRepository;

import curso.start.domain.Categorie;
import curso.start.domain.Cidade;
@org.springframework.stereotype.Repository
public interface RepositoryCidade extends CrudRepository<Cidade,Integer>{
		

}
