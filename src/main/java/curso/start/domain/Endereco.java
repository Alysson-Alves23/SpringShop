package curso.start.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ibge.IbgeApi;

@Entity
public class Endereco implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	private String logradouro;
	private short numero;
	private String complemento;
	private String bairro;
	private int cep;
	@OneToOne
	@JoinColumn(name= "cidade_id")
	private Cidade cidade;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name= "cliente_id")
	private Cliente cliente;
	
	
	public Endereco(){}
	
	
	
	
	public Endereco(String logradouro, short numero, String complemento, String bairro, int cep,Cliente cliente, Cidade cidade) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cliente= cliente;
		this.cidade= cidade;
	}
	public Endereco(String logradouro, short numero, String bairro, int cep,Cliente cliente, Cidade cidade) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cliente= cliente;
		this.cidade= cidade;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public short getnumero() {
		return numero;
	}


	public void setnumero(short numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public int getCep() {
		return cep;
	}


	public void setCep(int cep) {
		this.cep = cep;
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
		Endereco other = (Endereco) obj;
		if (id != other.id)
			return false;
		return true;
	}




	public Cliente getCliente() {
		return cliente;
	}




	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	public Cidade getCidade() {
		return cidade;
	}




	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
	
}
