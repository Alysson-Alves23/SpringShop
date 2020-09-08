package curso.start.resource.exeptions;

import java.io.Serializable;

public class StandardException implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private String msg;
	private double time;
	public StandardException(int codigo, String msg, double tempo) {
		super();
		this.codigo = codigo;
		this.msg = msg;
		this.time = tempo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double tempo) {
		this.time = tempo;
	}


}
