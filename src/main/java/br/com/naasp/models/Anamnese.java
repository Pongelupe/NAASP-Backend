package br.com.naasp.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
public class Anamnese {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int anamneseId;

	private String demandaApresentada;
	private String encaminhamento;
	private String observacoes;
	private String retornoAgendado;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	private static class AnamneseKeys {
		private static final String DEMANDA_APRESENTADA = "demandaApresentada";
		private static final String ENCAMINHAMENTO = "encaminhamento";
		private static final String OBSERVACOES = "observacoes";
		private static final String RETORNO_AGENDADO = "retornoAgendado";
	}

	public int getAnamneseId() {
		return anamneseId;
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Deprecated
	public Anamnese() {
	}

	@Override
	public String toString() {
		return "Anamnese [anamneseId=" + anamneseId + ", demandaApresentada=" + demandaApresentada + ", encaminhamento="
				+ encaminhamento + ", observacoes=" + observacoes + ", retornoAgendado=" + retornoAgendado
				+ ", paciente=" + paciente + "]";
	}

	public Anamnese(JSONObject json) throws JSONException {
		if (json.has(AnamneseKeys.DEMANDA_APRESENTADA))
			demandaApresentada = json.getString(AnamneseKeys.DEMANDA_APRESENTADA);
		else
			throw new JSONException("missing " + AnamneseKeys.DEMANDA_APRESENTADA);

		if (json.has(AnamneseKeys.ENCAMINHAMENTO) && !json.getString(AnamneseKeys.ENCAMINHAMENTO).isEmpty())
			encaminhamento = json.getString(AnamneseKeys.ENCAMINHAMENTO);
		else
			encaminhamento = "NAO INFORMADO";

		if (json.has(AnamneseKeys.OBSERVACOES) && !json.getString(AnamneseKeys.OBSERVACOES).isEmpty())
			observacoes = json.getString(AnamneseKeys.OBSERVACOES);
		else
			observacoes = "NAO POSSUI";

		if (json.has(AnamneseKeys.RETORNO_AGENDADO))
			retornoAgendado = json.getString(AnamneseKeys.RETORNO_AGENDADO);
		else
			throw new JSONException("missing " + AnamneseKeys.RETORNO_AGENDADO);
	}

	public Anamnese(String demandaApresentada, String encaminhamento, String observacoes, String retornoAgendado,
			Paciente paciente) {
		this.demandaApresentada = demandaApresentada;
		this.encaminhamento = encaminhamento;
		this.observacoes = observacoes;
		this.retornoAgendado = retornoAgendado;
		this.paciente = paciente;
	}

}
