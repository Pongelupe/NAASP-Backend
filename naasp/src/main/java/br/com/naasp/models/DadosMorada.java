package br.com.naasp.models;

public class DadosMorada {

	private String tipo;
	private String descricaoMorada;

	public String getDescricaoMorada() {
		return descricaoMorada;
	}

	public void setDescricaoMorada(String descricaoMorada) {
		this.descricaoMorada = descricaoMorada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "DadosMorada [tipo=" + tipo + ", descricaoMorada=" + descricaoMorada + "]";
	}

}
