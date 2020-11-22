package curso.start.domain;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento{
	
	private static final long serialVersionUID = 1L;
	
	private int numeroDeParcelas;

	public PagamentoComCartao() {
		
		
	}
	public PagamentoComCartao(int parcelas, int estadoPagamento,Pedido pedido) {
		super(estadoPagamento, pedido);
		this.numeroDeParcelas = parcelas;
		
	}

	
	public int getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(int numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
