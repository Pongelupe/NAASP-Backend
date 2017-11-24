package br.com.naasp.service.models;

import org.json.JSONException;
import org.json.JSONObject;

public class CadastroVoluntarioResposta extends Resposta {

	private String idVoluntario;

	public static class CadastroVoluntarioRespostaKeys {
		public static final String ID_VOLUNTARIO = "idVoluntario";
	}

	public CadastroVoluntarioResposta(boolean erro) {
		super(erro);
	}

	public String getIdVoluntario() {
		return idVoluntario;
	}

	public void setIdVoluntario(String idVoluntario) {
		this.idVoluntario = idVoluntario;
	}

	@Override
	public JSONObject toJson() {
		JSONObject json = super.toJson();
		try {
			json.put(CadastroVoluntarioRespostaKeys.ID_VOLUNTARIO, idVoluntario);
		} catch (JSONException e) {
			json = new Resposta(e.toString()).toJson();
		}
		return json;
	}
}
