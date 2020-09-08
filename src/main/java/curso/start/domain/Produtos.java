package curso.start.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Produtos {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double value;
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA",
	joinColumns = @JoinColumn(name = "produto_id"),
	inverseJoinColumns = @JoinColumn(name = "categoria_id") )
	private List<Categorie> categorias=new ArrayList<>();
	public Produtos(String name, double value) {
		this.name=name;
		this.value=value;
	}
	public Produtos() {

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


	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public List<Categorie> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categorie> categorias) {
		this.categorias = categorias;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
