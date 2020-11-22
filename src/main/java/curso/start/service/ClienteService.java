package curso.start.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.start.domain.Cliente;
import curso.start.repository.RepositoryCli;
import curso.start.service.exceptions.ObjectNotFoundException;
@Service
public class ClienteService {
	
	@Autowired
	RepositoryCli repo;
	
	public Cliente findByid(int id) throws ObjectNotFoundException{
			
		Optional<Cliente> cat= repo.findById(id);
		if(!cat.isEmpty()) { 
		 return cat.orElse(null);
		 }else {throw  new ObjectNotFoundException("Id "+id+" não encontrado"); }
		
	}
	

	public Cliente Create(Cliente cli) {
		
		Cliente p=repo.save(cli);
		
		return p;
	}
	public void Delete(int id) {
		
		repo.deleteById(id);
		
	};
	public Iterable<Cliente> listAll(){
	 
		return repo.findAll();
	}
	
//	public Cliente Update(Cliente cli) {
//		try {
//		
//// recebe um cliente e busca por id
//			
//			repo.save(cli);
//// cria um novo cliente com o mesmo id e substitui
//			
//			return cli;
//		}catch(ObjectNotFoundException e) {
//			
//			return null;
//			
//		}
		
	
}
