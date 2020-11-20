package curso.start.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.start.domain.Cliente;
@Repository
public interface RepositoryCli extends CrudRepository<Cliente,Integer>{

}
