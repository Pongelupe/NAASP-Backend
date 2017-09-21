package br.com.naasp.models;

import org.json.JSONException;
import org.json.JSONObject;

public class DadosFamiliar {

	private String parentesco;
	private String profissao;
	private String escolaridade;
	private int idade;

	private static class DadosFamiliaresKeys {
		public static final String PARENTESCO = "parentesco";
		public static final String PROFISSAO = "profissao";
		public static final String ESCOLARIDADE = "escolaridade";
		public static final String IDADE = "idade";
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public DadosFamiliar(String parentesco, String profissao, String escolaridade, int idade) {
		this.parentesco = parentesco;
		this.profissao = profissao;
		this.escolaridade = escolaridade;
		this.idade = idade;
	}

	public DadosFamiliar(JSONObject json) throws JSONException {
		if (json.has(DadosFamiliaresKeys.PARENTESCO))
			parentesco = json.getString(DadosFamiliaresKeys.PARENTESCO);

		if (json.has(DadosFamiliaresKeys.PROFISSAO))
			parentesco = json.getString(DadosFamiliaresKeys.PROFISSAO);

		if (json.has(DadosFamiliaresKeys.ESCOLARIDADE))
			parentesco = json.getString(DadosFamiliaresKeys.ESCOLARIDADE);

		if (json.has(DadosFamiliaresKeys.IDADE))
			idade = json.getInt(DadosFamiliaresKeys.IDADE);
	}

	@Override
	public String toString() {
		return "DadosFamiliar [parentesco=" + parentesco + ", profissao=" + profissao + ", escolaridade=" + escolaridade
				+ ", idade=" + idade + "]";
	}

}
