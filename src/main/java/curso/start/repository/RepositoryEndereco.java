package curso.start.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.start.domain.Endereco;

@Repository
public interface RepositoryEndereco extends CrudRepository<Endereco, Integer>{

}
