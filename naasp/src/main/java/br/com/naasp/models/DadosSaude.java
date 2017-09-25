package br.com.naasp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
public class DadosSaude {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dadosSaudeId;

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
		return "DadosSaude [dadosSaudeId=" + dadosSaudeId + ", quemQuais=" + quemQuais + "]";
	}

}
