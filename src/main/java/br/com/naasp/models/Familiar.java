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
public class Familiar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int familiarId;

	private String parentesco;
	private String profissao;
	private String escolaridade;
	private int idade;

	@JoinColumn(name = "id_famila")
	@ManyToOne(fetch = FetchType.EAGER)
	private DadosFamiliar dadosFamiliar;

	private static class FamiliarKeys {
		public static final String ID = "idFamila";
		public static final String PARENTESCO = "parentesco";
		public static final String PROFISSAO = "profissao";
		public static final String ESCOLARIDADE = "escolaridade";
		public static final String IDADE = "idade";
	}

	public Familiar(String parentesco, String profissao, String escolaridade, int idade) {
		this.parentesco = parentesco;
		this.profissao = profissao;
		this.escolaridade = escolaridade;
		this.idade = idade;
	}

	@Deprecated
	public Familiar() {
	}

	public Familiar(JSONObject json) throws JSONException {
		if (json.has(FamiliarKeys.PARENTESCO))
			parentesco = json.getString(FamiliarKeys.PARENTESCO);
		else
			throw new JSONException("missing " + FamiliarKeys.PARENTESCO + " on Familiar");

		if (json.has(FamiliarKeys.PROFISSAO))
			profissao = json.getString(FamiliarKeys.PROFISSAO);
		else
			throw new JSONException("missing " + FamiliarKeys.PROFISSAO + " on Familiar");

		if (json.has(FamiliarKeys.ESCOLARIDADE))
			escolaridade = json.getString(FamiliarKeys.ESCOLARIDADE);
		else
			throw new JSONException("missing " + FamiliarKeys.ESCOLARIDADE + " on Familiar");

		if (json.has(FamiliarKeys.IDADE))
			idade = json.getInt(FamiliarKeys.IDADE);
		else
			throw new JSONException("missing " + FamiliarKeys.IDADE + " on Familiar");
	}

	@Override
	public String toString() {
		return "DadosFamiliar [familiaId=" + familiarId + ", parentesco=" + parentesco + ", profissao=" + profissao
				+ ", escolaridade=" + escolaridade + ", idade=" + idade;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		try {
			json.put(FamiliarKeys.ID, familiarId);
			json.put(FamiliarKeys.PARENTESCO, parentesco);
			json.put(FamiliarKeys.PROFISSAO, profissao);
			json.put(FamiliarKeys.ESCOLARIDADE, escolaridade);
			json.put(FamiliarKeys.IDADE, idade);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return json;
	}

}
