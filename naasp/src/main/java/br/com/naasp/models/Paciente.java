package br.com.naasp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Paciente extends Usuario {

	// Dados Pessoais
	private DadosPessoal dadosPessoais;
	// Dados Familiares
	private List<DadosFamiliar> dadosFamiliares;
	// Dados de Morada
	private DadosMorada dadosMorada;
	// Dados de Saúde
	private DadosSaude dadosSaude;
	// Dados Paróquia
	private DadosParoquias dadosParoquia;

	public DadosPessoal getDadosPessoais() {
		return dadosPessoais;
	}

	public List<DadosFamiliar> getDadosFamiliares() {
		return dadosFamiliares;
	}

	public DadosMorada getDadosMorada() {
		return dadosMorada;
	}

	public DadosSaude getDadosSaude() {
		return dadosSaude;
	}

	public DadosParoquias getDadosParoquia() {
		return dadosParoquia;
	}

	@Override
	public String toString() {
		return super.toString() + " Paciente [dadosPessoais=" + dadosPessoais + ", dadosFamiliares=" + dadosFamiliares
				+ ", dadosMorada=" + dadosMorada + ", dadosSaude=" + dadosSaude + ", dadosParoquia=" + dadosParoquia
				+ "]";
	}

	private Paciente(String nome, String senha, DadosPessoal dadosPessoais, List<DadosFamiliar> dadosFamiliares,
			DadosMorada dadosMorada, DadosSaude dadosSaude, DadosParoquias dadosParoquia) {
		super(nome, senha);
		this.dadosPessoais = dadosPessoais;
		this.dadosFamiliares = dadosFamiliares;
		this.dadosMorada = dadosMorada;
		this.dadosSaude = dadosSaude;
		this.dadosParoquia = dadosParoquia;
	}

	public class PacienteBuilder {
		private DadosPessoal dadosPessoais;
		private List<DadosFamiliar> dadosFamiliares = new ArrayList<DadosFamiliar>();
		private DadosMorada dadosMorada;
		private DadosSaude dadosSaude;
		private DadosParoquias dadosParoquias;
		private String nome;
		private String senha;

		public void addNome(String nome) {
			this.nome = nome;
		}

		public void addSenha(String senha) {
			this.senha = senha;
		}

		public void addDadosPessoais(DadosPessoal dadosPessoais) {
			this.dadosPessoais = dadosPessoais;
		}

		public void addDadosFamiliar(DadosFamiliar dadosFamiliar) {
			this.dadosFamiliares.add(dadosFamiliar);
		}

		public void addDadosMorada(DadosMorada dadosMorada) {
			this.dadosMorada = dadosMorada;
		}

		public void addDadosSaude(DadosSaude dadosSaude) {
			this.dadosSaude = dadosSaude;
		}

		public void addDadosParoquias(DadosParoquias dadosParoquias) {
			this.dadosParoquias = dadosParoquias;
		}

		public Paciente build() {
			return new Paciente(nome, senha, dadosPessoais, dadosFamiliares, dadosMorada, dadosSaude, dadosParoquias);
		}

	}
}
