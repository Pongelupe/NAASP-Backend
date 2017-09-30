package br.com.naasp.service.models;

import org.json.JSONException;
import org.json.JSONObject;

public class CadastroPacienteResposta extends Resposta {

	private String idPaciente;

	public static class CadastroPacienteRespostaKeys {
		public static final String ID_PACIENTE = "idPaciente";
	}

	public CadastroPacienteResposta(boolean erro) {
		super(erro);
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		try {
			json.put("Resposta", super.toJson());
			json.put(CadastroPacienteRespostaKeys.ID_PACIENTE, idPaciente);
		} catch (JSONException e) {
			json = new Resposta(e.toString()).toJson();
		}
		return json;
	}
}
