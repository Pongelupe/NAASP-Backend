package br.com.naasp.models;

public class DadosFamiliar {

	private String nome;
	private String parentesco;
	private String profissao;
	private String escolaridade;
	private int idade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public DadosFamiliar(String nome, String parentesco, String profissao, String escolaridade, int idade) {
		this.nome = nome;
		this.parentesco = parentesco;
		this.profissao = profissao;
		this.escolaridade = escolaridade;
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "DadosFamiliar [nome=" + nome + ", parentesco=" + parentesco + ", profissao=" + profissao
				+ ", escolaridade=" + escolaridade + ", idade=" + idade + "]";
	}

}
