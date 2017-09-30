package br.com.naasp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
public class DadosMorada {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int moradaId;

	private String tipo;
	private String descricaoMorada;

	private static class DadosMoradaKeys {
		public static final String TIPO = "tipo";
		public static final String DESCRICAO_MORADA = "descricaoMoradia";
	}

	public DadosMorada(String tipo, String descricaoMorada) {
		this.tipo = tipo;
		this.descricaoMorada = descricaoMorada;
	}

	public DadosMorada(JSONObject json) throws JSONException {
		if (json.has(DadosMoradaKeys.TIPO))
			tipo = json.getString(DadosMoradaKeys.TIPO);
		else
			throw new JSONException("missing " + DadosMoradaKeys.TIPO);

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
		return "DadosMorada [moradaId=" + moradaId + ", tipo=" + tipo + ", descricaoMorada=" + descricaoMorada + "]";
	}

}
