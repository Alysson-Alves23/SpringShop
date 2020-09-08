package curso.start;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import curso.start.domain.Categorie;
import curso.start.domain.Produtos;
import curso.start.repository.RepositoryCat;
import curso.start.repository.RepositoryProd;
import curso.start.service.CategorieService;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
		
		
	}
	@Autowired
	RepositoryCat repoCat;
	@Autowired
	RepositoryProd repoProd;
	@Override
	public void run(String... args) throws Exception {
		
		Categorie cat1= new Categorie("Informática");
		Categorie cat2= new Categorie("Escritório");
		
		Produtos produto1= new Produtos("Impressora",550d);
		Produtos produto2= new Produtos("Monitor",230d);
		Produtos produto3= new Produtos("Mouse",30d);
		
		
		
		cat1.getProdutos().addAll(Arrays.asList(produto1,produto2,produto3));
		cat2.getProdutos().add(produto1);
		produto1.getCategorias().addAll(Arrays.asList(cat1,cat2));
		produto2.getCategorias().add(cat1);
		produto3.getCategorias().add(cat1);
repoCat.saveAll(Arrays.asList(cat1,cat2));
		repoProd.saveAll(Arrays.asList(produto1,produto2,produto3));
		
		
		
		
		
		
		
		
	}

}
