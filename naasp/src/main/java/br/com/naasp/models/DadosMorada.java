package br.com.naasp.models;

import org.json.JSONException;
import org.json.JSONObject;

public class DadosMorada {

	private String tipo;
	private String descricaoMorada;

	private static class DadosMoradaKeys {
		public static final String TIPO = "tipo";
		public static final String DESCRICAO_MORADA = "descricaoMorada";
	}

	public DadosMorada(JSONObject json) throws JSONException {
		if (json.has(DadosMoradaKeys.TIPO))
			tipo = json.getString(DadosMoradaKeys.TIPO);

		if (json.has(DadosMoradaKeys.DESCRICAO_MORADA))
			descricaoMorada = json.getString(DadosMoradaKeys.DESCRICAO_MORADA);
	}

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
