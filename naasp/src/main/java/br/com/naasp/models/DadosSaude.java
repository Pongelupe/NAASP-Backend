package br.com.naasp.models;

import org.json.JSONException;
import org.json.JSONObject;

public class DadosSaude {

	private String quemQuais;

	private static class DadosSaudeKeys {
		public static final String QUEM_QUAIS = "quemQuais";
	}

	public DadosSaude(JSONObject json) throws JSONException {
		if (json.has(DadosSaudeKeys.QUEM_QUAIS))
			quemQuais = json.getString(DadosSaudeKeys.QUEM_QUAIS);
	}

	public String getQuemQuais() {
		return quemQuais;
	}

	public void setQuemQuais(String quemQuais) {
		this.quemQuais = quemQuais;
	}

	@Override
	public String toString() {
		return "DadosSaude [quemQuais=" + quemQuais + "]";
	}

}
