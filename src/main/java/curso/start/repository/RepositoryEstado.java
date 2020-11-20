package curso.start.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import curso.start.domain.Estado;
@Repository
public interface RepositoryEstado extends CrudRepository<Estado,Integer>{
		

}
