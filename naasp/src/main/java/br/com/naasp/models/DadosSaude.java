package br.com.naasp.models;

public class DadosSaude {

	private String quemQuais;

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
