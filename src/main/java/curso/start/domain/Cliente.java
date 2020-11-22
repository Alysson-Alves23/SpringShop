package curso.start.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import curso.start.domain.enums.TipoCliente;
import ibge.IbgeApi;



@Entity
public class Cliente implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	private String nome;
	private String email;
	private long cpf_cnpj;
	private int tipo;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> endereco= new ArrayList();
	
	@ElementCollection
	@CollectionTable(name="telefone")
	private Set<Long> telefones= new HashSet<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos= new ArrayList();
	public Cliente() {}
	
	public Cliente( String nome, String email, long cpf_cnpj, int tipo) {
		super();
		
		this.nome = nome;
		this.email = email;
		this.cpf_cnpj = cpf_cnpj;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(long cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	

		public Set<Long> getTelefones() {
			return telefones;
		}

	public void setTelefones(Set<Long> telefones) {
		this.telefones = telefones;
	}
	

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}



}


	