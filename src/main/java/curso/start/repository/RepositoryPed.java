package curso.start.repository;

import org.springframework.data.repository.CrudRepository;

import curso.start.domain.Categorie;
import curso.start.domain.Pedido;
@org.springframework.stereotype.Repository
public interface RepositoryPed extends CrudRepository<Pedido,Integer>{
		

}
