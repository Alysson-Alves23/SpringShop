package curso.start.repository;

import org.springframework.data.repository.CrudRepository;

import curso.start.domain.Categorie;
import curso.start.domain.Pagamento;
@org.springframework.stereotype.Repository
public interface RepositoryPag extends CrudRepository<Pagamento,Integer>{
		

}
