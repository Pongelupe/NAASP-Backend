package br.com.naasp.models;

import java.io.File;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Relatorio {

	private final ArrayList<String> parametros = new ArrayList<String>();
	private String nome;

	private static class RelatorioKeys {

		private static final String PARAMETROS = "parametros";
	}

	private void setParametros(JSONArray jsonArray) throws JSONException {
		for (int i = 0; i < jsonArray.length(); i++)
			parametros.add(jsonArray.getString(i));
	}

	public String getNome() {
		return nome;
	}

	public File toFile() {
		return null;
	}

	public Relatorio(JSONObject json) throws JSONException {
		if (json.has(RelatorioKeys.PARAMETROS))
			setParametros(json.getJSONArray(RelatorioKeys.PARAMETROS));
	}

}
