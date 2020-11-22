package curso.start.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date instante;
	
	@ManyToOne()
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	@ManyToOne
	@JoinColumn(name="endereco_de_entrega_id")
	private Endereco enderecoDeEntrega;
	
	Pedido(){
		
		
	}
	
	
	
	
	public Pedido(Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Date getInstante() {
		return instante;
	}




	public void setInstante(Date instante) {
		this.instante = instante;
	}




	public Cliente getCliente() {
		return cliente;
	}




	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	public Pagamento getPagamento() {
		return pagamento;
	}




	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}




	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}




	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((instante == null) ? 0 : instante.hashCode());
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
		Pedido other = (Pedido) obj;
		if (id != other.id)
			return false;
		if (instante == null) {
			if (other.instante != null)
				return false;
		} else if (!instante.equals(other.instante))
			return false;
		return true;
	}
	
	
	

}
