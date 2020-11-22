package curso.start.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import curso.start.domain.enums.EstadoPagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private int pgest;
	@OneToOne
	@JoinColumn(name="pedido_id")
	@MapsId
	private Pedido pedido;
	
	
	Pagamento(){}
	
	public Pagamento(int pgest, Pedido pedido) {
		super();
		this.pgest = pgest;
		this.setPedido(pedido);
	}
	
	public int getId() {
		return id;
	} 
	public void setId(int id) {
		this.id=id;
	}
	public EstadoPagamento getPgest() {
		return EstadoPagamento.toEnum(pgest);
	}
	public void setPgest(int estpg) {
		this.pgest = estpg;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
