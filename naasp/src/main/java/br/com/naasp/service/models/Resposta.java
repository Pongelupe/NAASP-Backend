package br.com.naasp.service.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Resposta {

	private boolean erro;
	private String mensagem;

	public static class RespostaKeys {
		public static final String ERRO = "erro";
		public static final String MENSAGEM = "mensagem";
	}

	public Resposta(boolean erro) {
		this.erro = erro;
		this.mensagem = "";
	}

	public Resposta(String mensagem) {
		this.erro = false;
		this.mensagem = mensagem;
	}

	public boolean isErro() {
		return erro;
	}

	public void setErro(boolean erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		try {
			json.put(RespostaKeys.ERRO, erro);
			json.put(RespostaKeys.MENSAGEM, mensagem);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

}
