package br.com.naasp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
public class DadosParoquias {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paroquiaId;

	private String paroquiaBairro;
	private String descricaoAtividade;
	private String pastoralInserido;
	private String pastoralAcompanhado;
	private String atividadeOutrasInst;

	private static class DadosParoquiaKeys {
		public static final String PAROQUIA_BAIRRO = "paroquiaBairro";
		public static final String DESCRICAO_ATIVIDADE = "descricaoAtividade";
		public static final String PASTORAL_INSERIDO = "pastoralInserdo";
		public static final String PASTORAL_ACOMPANHADO = "pastoralAcompanhado";
		public static final String ATIVIDADE_OUTRAS_INST = "atividadeOutrasInst";
	}

	public DadosParoquias(JSONObject json) throws JSONException {
		if (json.has(DadosParoquiaKeys.PAROQUIA_BAIRRO))
			paroquiaBairro = json.getString(DadosParoquiaKeys.PAROQUIA_BAIRRO);

		if (json.has(DadosParoquiaKeys.DESCRICAO_ATIVIDADE))
			paroquiaBairro = json.getString(DadosParoquiaKeys.DESCRICAO_ATIVIDADE);

		if (json.has(DadosParoquiaKeys.PASTORAL_INSERIDO))
			paroquiaBairro = json.getString(DadosParoquiaKeys.PASTORAL_INSERIDO);

		if (json.has(DadosParoquiaKeys.PASTORAL_ACOMPANHADO))
			paroquiaBairro = json.getString(DadosParoquiaKeys.PASTORAL_ACOMPANHADO);

		if (json.has(DadosParoquiaKeys.ATIVIDADE_OUTRAS_INST))
			paroquiaBairro = json.getString(DadosParoquiaKeys.ATIVIDADE_OUTRAS_INST);
	}

	public DadosParoquias(String paroquiaBairro, String descricaoAtividade, String pastoralInserido,
			String pastoralAcompanhado, String atividadeOutrasInst) {
		this.paroquiaBairro = paroquiaBairro;
		this.descricaoAtividade = descricaoAtividade;
		this.pastoralInserido = pastoralInserido;
		this.pastoralAcompanhado = pastoralAcompanhado;
		this.atividadeOutrasInst = atividadeOutrasInst;
	}

	public String getParoquiaBairro() {
		return paroquiaBairro;
	}

	public void setParoquiaBairro(String paroquiaBairro) {
		this.paroquiaBairro = paroquiaBairro;
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}

	public String getPastoralInserido() {
		return pastoralInserido;
	}

	public void setPastoralInserido(String pastoralInserido) {
		this.pastoralInserido = pastoralInserido;
	}

	public String getPastoralAcompanhado() {
		return pastoralAcompanhado;
	}

	public void setPastoralAcompanhado(String pastoralAcompanhado) {
		this.pastoralAcompanhado = pastoralAcompanhado;
	}

	public String getAtividadeOutrasInst() {
		return atividadeOutrasInst;
	}

	public void setAtividadeOutrasInst(String atividadeOutrasInst) {
		this.atividadeOutrasInst = atividadeOutrasInst;
	}

	@Override
	public String toString() {
		return "DadosParoquias [paroquiaBairro=" + paroquiaBairro + ", descricaoAtividade=" + descricaoAtividade
				+ ", pastoralInserido=" + pastoralInserido + ", pastoralAcompanhado=" + pastoralAcompanhado
				+ ", atividadeOutrasInst=" + atividadeOutrasInst + "]";
	}

}
