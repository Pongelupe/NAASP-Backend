package br.com.naasp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
public class DadosGerais {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int idDadosGerais;

	private int numFicha;
	private String dataPrimeiroAtend;
	private String paroco;
	private String sacerdode;
	private String respAtendimento;

	private static class DadosGeraiskeys {

		private static final String NUM_FICHA = "numeroFicha";
		private static final String DATA_PRIM_ATENDIMENTO = "dataPrimeiroAtend";
		private static final String PAROCO = "paroco";
		private static final String SACERDOTE = "sacerdote";
		private static final String RESP_ATENDIMENTO = "respAtendimento";
	}

	public int getNumFicha() {
		return numFicha;
	}

	public void setNumFicha(int numFicha) {
		this.numFicha = numFicha;
	}

	public Integer getIdDadosGerais() {
		return idDadosGerais;
	}

	public void setIdIdDadosGerais(Integer idDadosGerais) {
		this.idDadosGerais = idDadosGerais;
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

	public String getRespAtendimento() {
		return respAtendimento;
	}

	public void setRespAtendimento(String respAtendimento) {
		this.respAtendimento = respAtendimento;
	}

	public String getSacerdode() {
		return sacerdode;
	}

	public void setSacerdode(String sacerdode) {
		this.sacerdode = sacerdode;
	}

	@Override
	public String toString() {
		return "DadosGerais [idDadosGerais=" + idDadosGerais + ", dataPrimeiroAtend=" + dataPrimeiroAtend + ", paroco="
				+ paroco + ", sacerdode=" + sacerdode + ", respAtendimento=" + respAtendimento + "]";
	}

	public DadosGerais(String dataPrimeiroAtend, String paroco, String sacerdode, String respAtendimento) {
		this.dataPrimeiroAtend = dataPrimeiroAtend;
		this.paroco = paroco;
		this.sacerdode = sacerdode;
		this.respAtendimento = respAtendimento;
	}

	public DadosGerais(JSONObject json) throws JSONException {

		if (json.has(DadosGeraiskeys.NUM_FICHA))
			setNumFicha(json.getInt(DadosGeraiskeys.NUM_FICHA));
		else
			throw new JSONException("missing " + DadosGeraiskeys.NUM_FICHA);

		if (json.has(DadosGeraiskeys.DATA_PRIM_ATENDIMENTO))
			setDataPrimeiroAtend(json.getString(DadosGeraiskeys.DATA_PRIM_ATENDIMENTO));
		else
			throw new JSONException("missing " + DadosGeraiskeys.DATA_PRIM_ATENDIMENTO);

		if (json.has(DadosGeraiskeys.PAROCO))
			setParoco(json.getString(DadosGeraiskeys.PAROCO));
		else
			throw new JSONException("missing " + DadosGeraiskeys.PAROCO);

		if (json.has(DadosGeraiskeys.SACERDOTE))
			setSacerdode(json.getString(DadosGeraiskeys.SACERDOTE));
		else
			throw new JSONException("missing " + DadosGeraiskeys.SACERDOTE);

		if (json.has(DadosGeraiskeys.RESP_ATENDIMENTO))
			setRespAtendimento(json.getString(DadosGeraiskeys.RESP_ATENDIMENTO));
		else
			throw new JSONException("missing " + DadosGeraiskeys.RESP_ATENDIMENTO);
	}

}