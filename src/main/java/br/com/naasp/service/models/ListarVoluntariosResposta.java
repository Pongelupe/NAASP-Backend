package br.com.naasp.service.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.naasp.models.Voluntario;

public class ListarVoluntariosResposta extends Resposta {

	public static class ListarvoluntariosRespostaKeys {
		public static final String VOLUNTARIOS = "voluntarios";
	}

	private ArrayList<Voluntario> voluntarios;

	public ListarVoluntariosResposta(boolean erro, ArrayList<Voluntario> voluntarios) {
		super(erro);
		this.voluntarios = voluntarios;
	}

	@Override
	public JSONObject toJson() {
		JSONObject json = super.toJson();
		JSONArray jsonArray = new JSONArray();
		try {
			voluntarios.forEach(p -> jsonArray.put(p.toJson()));

			json.put(ListarvoluntariosRespostaKeys.VOLUNTARIOS, jsonArray);
		} catch (JSONException e) {
			json = new Resposta(e.toString()).toJson();
		}
		return json;
	}

}
