package curso.start.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Categorie implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@JsonManagedReference
	@ManyToMany(mappedBy="categorias")
	private List<Produtos> produtos = new ArrayList<>(); 

	public Categorie(String name) {
		this.name=name;
	}
	public Categorie() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String nome) {
		this.name = nome;
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
		Categorie other = (Categorie) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public List<Produtos> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}


}
