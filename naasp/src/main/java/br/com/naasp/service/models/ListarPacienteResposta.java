package br.com.naasp.service.models;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.naasp.models.Paciente;

public class ListarPacienteResposta extends Resposta {

	public static class ListarPacienteRespostaKeys {
		public static final String PACIENTES = "pacientes";
	}

	private ArrayList<Paciente> pacientes;

	public ListarPacienteResposta(boolean erro, ArrayList<Paciente> pacientes) {
		super(erro);
		this.pacientes = pacientes;
	}

	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		try {
			json.put("Resposta", super.toJson());
			json.put(ListarPacienteRespostaKeys.PACIENTES, pacientes);
		} catch (JSONException e) {
			json = new Resposta(e.toString()).toJson();
		}
		return json;
	}

}
