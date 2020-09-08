package curso.start.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.start.domain.Produtos;
@Repository
public interface RepositoryProd extends CrudRepository<Produtos,Integer>{
		

}
