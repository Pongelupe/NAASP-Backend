package br.com.naasp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Paciente extends Usuario {

	private int numFicha;
	private String dataPrimeiroAtend;
	private String paroco;
	private String sacerdode;
	private String respAtendimento;

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

	public int getNumFicha() {
		return numFicha;
	}

	public void setNumFicha(int numFicha) {
		this.numFicha = numFicha;
	}

	public String getDataPrimeiroAtend() {
		return dataPrimeiroAtend;
	}

	public void setDataPrimeiroAtend(String dataPrimeiroAtend) {
		this.dataPrimeiroAtend = dataPrimeiroAtend;
	}

	public String getParoco() {
		return paroco;
	}

	public void setParoco(String paroco) {
		this.paroco = paroco;
	}

	public String getSacerdode() {
		return sacerdode;
	}

	public void setSacerdode(String sacerdode) {
		this.sacerdode = sacerdode;
	}

	public String getRespAtendimento() {
		return respAtendimento;
	}

	public void setRespAtendimento(String respAtendimento) {
		this.respAtendimento = respAtendimento;
	}

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
		return super.toString() + " Paciente [numFicha=" + numFicha + ", dataPrimeiroAtend=" + dataPrimeiroAtend
				+ ", paroco=" + paroco + ", sacerdode=" + sacerdode + ", respAtendimento=" + respAtendimento
				+ ", dadosPessoais=" + dadosPessoais + ", dadosFamiliares=" + dadosFamiliares + ", dadosMorada="
				+ dadosMorada + ", dadosSaude=" + dadosSaude + ", dadosParoquia=" + dadosParoquia + "]";
	}

	private Paciente(String nome, String senha, int numFicha, String dataPrimAtend, String paroco, String sacerdote,
			String respAtendimento, DadosPessoal dadosPessoais, List<DadosFamiliar> dadosFamiliares,
			DadosMorada dadosMorada, DadosSaude dadosSaude, DadosParoquias dadosParoquia) {
		super(nome, senha);
		this.numFicha = numFicha;
		this.dataPrimeiroAtend = dataPrimAtend;
		this.paroco = paroco;
		this.sacerdode = sacerdote;
		this.respAtendimento = respAtendimento;
		this.dadosPessoais = dadosPessoais;
		this.dadosFamiliares = dadosFamiliares;
		this.dadosMorada = dadosMorada;
		this.dadosSaude = dadosSaude;
		this.dadosParoquia = dadosParoquia;
	}

	public class PacienteBuilder {
		private String nome;
		private String senha;
		private int numFicha;
		private String dataPrimeiroAtend;
		private String paroco;
		private String sacerdote;
		private String respAtendimento;
		private DadosPessoal dadosPessoais;
		private List<DadosFamiliar> dadosFamiliares = new ArrayList<DadosFamiliar>();
		private DadosMorada dadosMorada;
		private DadosSaude dadosSaude;
		private DadosParoquias dadosParoquias;

		public void addNome(String nome) {
			this.nome = nome;
		}

		public void addSenha(String senha) {
			this.senha = senha;
		}

		public void addNumFicha(int numFicha) {
			this.numFicha = numFicha;
		}

		public void addDataPrimeiroAtend(String dataPrimAtendimento) {
			this.dataPrimeiroAtend = dataPrimAtendimento;
		}

		public void addParoco(String paroco) {
			this.paroco = paroco;
		}

		public void addSacerdote(String sacerdote) {
			this.sacerdote = sacerdote;
		}

		public void addRespAtendimento(String respAtendimento) {
			this.respAtendimento = respAtendimento;
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
			return new Paciente(nome, senha, numFicha, dataPrimeiroAtend, paroco, sacerdote, respAtendimento,
					dadosPessoais, dadosFamiliares, dadosMorada, dadosSaude, dadosParoquias);
		}

	}
}
