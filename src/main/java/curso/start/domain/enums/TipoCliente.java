package curso.start.domain.enums;

public enum TipoCliente {

	
	PESSOAJURIDICA(1,"Pessoa Jurídica"),
	PESSOAFISICA(2,"Pessoa Física");
	
	private int cod;
	private String descricao;



	private TipoCliente(int cod, String descricao) {
	
		this.cod = cod;
		this.descricao = descricao;
	
	}
	
	public  int getCod(){
		return this.cod;
	}
	public String getDescricacao() {
		return this.descricao;
	}
	
	public static  TipoCliente toEnum( Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCliente  x : TipoCliente.values()){
				if (cod == x.getCod()) {
					return x;
					}
				}
		throw new IllegalArgumentException("Id inválido: " + cod);
		
	}
	
}
