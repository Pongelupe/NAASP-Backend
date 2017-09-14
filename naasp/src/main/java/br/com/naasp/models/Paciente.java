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

	public void setDadosPessoais(DadosPessoal dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public List<DadosFamiliar> getDadosFamiliares() {
		return dadosFamiliares;
	}

	public void setDadosFamiliares(List<DadosFamiliar> dadosFamiliares) {
		this.dadosFamiliares = dadosFamiliares;
	}

	public DadosMorada getDadosMorada() {
		return dadosMorada;
	}

	public void setDadosMorada(DadosMorada dadosMorada) {
		this.dadosMorada = dadosMorada;
	}

	public DadosSaude getDadosSaude() {
		return dadosSaude;
	}

	public void setDadosSaude(DadosSaude dadosSaude) {
		this.dadosSaude = dadosSaude;
	}

	public DadosParoquias getDadosParoquia() {
		return dadosParoquia;
	}

	public void setDadosParoquia(DadosParoquias dadosParoquia) {
		this.dadosParoquia = dadosParoquia;
	}

	@Override
	public String toString() {
		return "Paciente [dadosPessoais=" + dadosPessoais + ", dadosFamiliares=" + dadosFamiliares + ", dadosMorada="
				+ dadosMorada + ", dadosSaude=" + dadosSaude + ", dadosParoquia=" + dadosParoquia + "]";
	}

	Paciente() {
		dadosPessoais = new DadosPessoal();
		dadosFamiliares = new ArrayList<DadosFamiliar>();
		dadosMorada = new DadosMorada();
		dadosSaude = new DadosSaude();
		dadosParoquia = new DadosParoquias();
	}
}
