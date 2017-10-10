package br.com.naasp.service.models;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.naasp.models.Anamnese;

public class CadastroAnamneseChamada {

	private final int idPaciente;
	private final Anamnese anamnse;

	private static class CadastroAnamneseChamadaKeys {
		private static final String ID_PACIENTE = "idPaciente";
		private static final String ANAMNESE = "anamnese";
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public Anamnese getAnamnse() {
		return anamnse;
	}

	public CadastroAnamneseChamada(JSONObject json) throws JSONException {
		if (json.has(CadastroAnamneseChamadaKeys.ID_PACIENTE))
			this.idPaciente = Integer.parseInt(json.getString(CadastroAnamneseChamadaKeys.ID_PACIENTE));
		else
			throw new JSONException("missing " + CadastroAnamneseChamadaKeys.ID_PACIENTE);

		if (json.has(CadastroAnamneseChamadaKeys.ANAMNESE))
			this.anamnse = new Anamnese(json.getJSONObject(CadastroAnamneseChamadaKeys.ANAMNESE));
		else
			throw new JSONException("missing " + CadastroAnamneseChamadaKeys.ANAMNESE);
	}

}
