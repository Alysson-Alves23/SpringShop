package curso.start;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import curso.start.domain.Categorie;
import curso.start.domain.Cidade;
import curso.start.domain.Cliente;
import curso.start.domain.Endereco;
import curso.start.domain.Estado;
import curso.start.domain.Pagamento;
import curso.start.domain.PagamentoComBoleto;
import curso.start.domain.PagamentoComCartao;
import curso.start.domain.Pedido;
import curso.start.domain.Produtos;
import curso.start.domain.Telefone;
import curso.start.repository.RepositoryCat;
import curso.start.repository.RepositoryCidade;
import curso.start.repository.RepositoryCli;
import curso.start.repository.RepositoryEndereco;
import curso.start.repository.RepositoryEstado;
import curso.start.repository.RepositoryPag;
import curso.start.repository.RepositoryPed;
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
	@Autowired
	RepositoryCli repoCli;
	@Autowired
	RepositoryCidade repoCid;
	@Autowired
	RepositoryEstado repoEst;
	@Autowired
	RepositoryEndereco repoEnd;
	@Autowired
	RepositoryPed repoPed;
	@Autowired
	RepositoryPag repoPag;
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
		
		Estado est1 = new Estado("Minas Gerais");
		Estado est2 = new Estado("São Paulo");
		
		Cidade c1= new Cidade("Campinas",est1);
		Cidade c2= new Cidade("Uberlândia",est2);
		Cidade c3= new Cidade("São Paulo", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		repoEst.saveAll(Arrays.asList(est1,est2));
		repoCid.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1= new Cliente("Alysson de Jesus Alves","alyssonja23@gmail.com",89046578554l,1);
		cli1.getTelefones().addAll(Arrays.asList(74991259225l,74991038714l));
		Endereco end1 = new Endereco("Rua Sergipe",(short)33,"Novo Horizonte",48970000,cli1,c1); 
		Endereco end2 = new Endereco("Rua Pedro Amaral",(short)21,"São Jorge",48970000,cli1,c1);
		
		repoCli.save(cli1);
		
		
		repoEnd.saveAll(Arrays.asList(end1,end2));
		
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yy HH:mm");
		SimpleDateFormat sdf2= new SimpleDateFormat("dd/MM/yy");
		
		Pedido ped1 = new Pedido(sdf.parse("21/11/2020 20:23"),cli1,end1);
		Pedido ped2 = new Pedido(sdf.parse("21/11/2020 10:54"),cli1,end2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		Pagamento pag1 = new PagamentoComCartao(3,2,ped1);
		Pagamento pag2= new PagamentoComBoleto(1,ped2,sdf2.parse("04/12/2020"),null);
		
		
		repoPag.saveAll(Arrays.asList(pag1,pag2));
		repoPed.saveAll(Arrays.asList(ped1,ped2));
		
		
	}

}
