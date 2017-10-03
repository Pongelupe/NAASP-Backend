package br.com.naasp.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int telefoneId;

	public String telefone;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pessoa")
	private DadosPessoal dadosPessoal;

	private static class TelefoneKeys {
		private static final String ID_TELEFONE = "id_telefone";
		private static final String TELEFONE = "telefone";
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public DadosPessoal getDadosPessoal() {
		return dadosPessoal;
	}

	public void setDadosPessoal(DadosPessoal dadosPessoal) {
		this.dadosPessoal = dadosPessoal;
	}

	public int getTelefoneId() {
		return telefoneId;
	}

	@Deprecated
	public Telefone() {
	}

	public Telefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Telefone [telefoneId=" + telefoneId + ", telefones=" + telefone + "]";
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();

		try {
			json.put(TelefoneKeys.ID_TELEFONE, telefoneId);
			json.put(TelefoneKeys.TELEFONE, telefone);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return json;
	}

}