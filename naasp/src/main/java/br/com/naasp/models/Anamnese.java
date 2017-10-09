package br.com.naasp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anamnese {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String demandaApresentada;
	private String encaminhamento;
	private String observacoes;
	private String retornoAgendado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDemandaApresentada() {
		return demandaApresentada;
	}

	public void setDemandaApresentada(String demandaApresentada) {
		this.demandaApresentada = demandaApresentada;
	}

	public String getEncaminhamento() {
		return encaminhamento;
	}

	public void setEncaminhamento(String encaminhamento) {
		this.encaminhamento = encaminhamento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getRetornoAgendado() {
		return retornoAgendado;
	}

	public void setRetornoAgendado(String retornoAgendado) {
		this.retornoAgendado = retornoAgendado;
	}

	@Override
	public String toString() {
		return "Anamnese [id=" + id + ", demandaApresentada=" + demandaApresentada + ", encaminhamento="
				+ encaminhamento + ", observacoes=" + observacoes + ", retornoAgendado=" + retornoAgendado + "]";
	}

	@Deprecated
	public Anamnese() {
	}

}
