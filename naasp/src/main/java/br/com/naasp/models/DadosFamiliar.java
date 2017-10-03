package br.com.naasp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Entity
public class DadosFamiliar {

	private static final String NAO_INFORMADO = "NÃO INFORMADO";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int familiaId;

	@JoinColumn(name = "id_familia")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Familiar> familiares;

	private String ajudaGoverno;

	private static final class DadosFamiliarKeys {
		public static final String FAMILIARES = "familiares";
		public static final String AJUDA_GOVERNO = "beneficioGoverno";
	}

	public DadosFamiliar(JSONObject jsonObject) throws JSONException {

		if (jsonObject.has(DadosFamiliarKeys.FAMILIARES))
			setFamiliares(jsonObject.getJSONArray(DadosFamiliarKeys.FAMILIARES));

		if (jsonObject.has(DadosFamiliarKeys.FAMILIARES))
			ajudaGoverno = jsonObject.getString(DadosFamiliarKeys.AJUDA_GOVERNO);
		else
			ajudaGoverno = NAO_INFORMADO;
	}

	private void setFamiliares(JSONArray jsonArray) throws JSONException {
		this.familiares = new ArrayList<Familiar>();

		for (int i = 0; i < jsonArray.length(); i++)
			this.familiares.add(new Familiar(jsonArray.getJSONObject(i)));
	}

	public int getPacienteId() {
		return familiaId;
	}

	public String getAjudaGoverno() {
		return ajudaGoverno;
	}

	public void setAjudaGoverno(String ajudaGoverno) {
		this.ajudaGoverno = ajudaGoverno;
	}

	public int getFamiliaId() {
		return familiaId;
	}

	public List<Familiar> getFamiliares() {
		return familiares;
	}

	@Deprecated
	public DadosFamiliar() {
	}

	@Override
	public String toString() {
		return "DadosFamiliar [familiaId=" + familiaId + ", familiares=" + familiares + ", ajudaGoverno=" + ajudaGoverno
				+ "]";
	}

	public JSONObject toJson() throws JSONException {
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		json.put(DadosFamiliarKeys.AJUDA_GOVERNO, ajudaGoverno);
		familiares.forEach(f -> jsonArray.put(f.toJson()));
		json.put(DadosFamiliarKeys.FAMILIARES, jsonArray);

		return json;
	}

}
