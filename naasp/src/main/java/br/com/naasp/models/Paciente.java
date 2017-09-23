package br.com.naasp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Entity
public class Paciente {

	@Id
	@GeneratedValue
	private Integer idPaciente;

	private int numFicha;
	private String dataPrimeiroAtend;
	private String paroco;
	private String sacerdode;
	private String respAtendimento;

	@OneToOne
	private DadosPessoal dadosPessoais;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_paciente")
	private List<DadosFamiliar> dadosFamiliares = new ArrayList<DadosFamiliar>();
	@OneToOne
	private DadosMorada dadosMorada;
	@OneToOne
	private DadosSaude dadosSaude;
	@OneToOne
	private DadosParoquias dadosParoquia;

	private static class PacienteKeys {
		private static final String NUM_FICHA = "numFicha";
		private static final String DATA_PRIM_ATENDIMENTO = "dataPrimAtend";
		private static final String PAROCO = "paroco";
		private static final String SACERDOTE = "sacerdode";
		private static final String RESP_ATENDIMENTO = "respAtendimento";
		private static final String DADOS_PESSOAIS = "dadosPessoais";
		private static final String DADOS_FAMILIARES = "dadosFamiliares";
		private static final String DADOS_MORADA = "dadosMorada";
		private static final String DADOS_SAUDE = "dadosSaude";
		private static final String DADOS_PAROQUIA = "dadosSaude";
	}

	public int getId() {
		return idPaciente;
	}

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

	private void setDadosPessoais(JSONObject jsonObject) throws JSONException {
		this.dadosPessoais = new DadosPessoal(jsonObject);
	}

	private void setDadosMorada(JSONObject jsonObject) throws JSONException {
		this.dadosMorada = new DadosMorada(jsonObject);
	}

	private void setDadosFamiliares(JSONArray jsonArray) throws JSONException {
		this.dadosFamiliares = new ArrayList<DadosFamiliar>();

		for (int i = 0; i < jsonArray.length(); i++)
			dadosFamiliares.add(new DadosFamiliar(jsonArray.getJSONObject(i)));
	}

	private void setDadosSaude(JSONObject jsonObject) throws JSONException {
		this.dadosSaude = new DadosSaude(jsonObject);
	}

	private void setDadosParoquia(JSONObject jsonObject) throws JSONException {
		this.dadosParoquia = new DadosParoquias(jsonObject);
	}

	public void setDadosFamiliares(List<DadosFamiliar> dadosFamiliares) {
		this.dadosFamiliares = dadosFamiliares;
	}

	@Override
	public String toString() {
		return super.toString() + " Paciente [numFicha=" + numFicha + ", dataPrimeiroAtend=" + dataPrimeiroAtend
				+ ", paroco=" + paroco + ", sacerdode=" + sacerdode + ", respAtendimento=" + respAtendimento
				+ ", dadosPessoais=" + dadosPessoais + ", dadosFamiliares=" + dadosFamiliares + ", dadosMorada="
				+ dadosMorada + ", dadosSaude=" + dadosSaude + ", dadosParoquia=" + dadosParoquia + "]";
	}

	private Paciente(int numFicha, String dataPrimAtend, String paroco, String sacerdote, String respAtendimento,
			DadosPessoal dadosPessoais, List<DadosFamiliar> dadosFamiliares, DadosMorada dadosMorada,
			DadosSaude dadosSaude, DadosParoquias dadosParoquia) {
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

	public Paciente() {
		this.dadosFamiliares = new ArrayList<DadosFamiliar>();
	}

	public Paciente(JSONObject json) throws JSONException {
		if (json.has(PacienteKeys.NUM_FICHA))
			setNumFicha(json.getInt(PacienteKeys.NUM_FICHA));

		if (json.has(PacienteKeys.DATA_PRIM_ATENDIMENTO))
			setDataPrimeiroAtend(json.getString(PacienteKeys.DATA_PRIM_ATENDIMENTO));

		if (json.has(PacienteKeys.PAROCO))
			setParoco(json.getString(PacienteKeys.PAROCO));

		if (json.has(PacienteKeys.SACERDOTE))
			setSacerdode(json.getString(PacienteKeys.SACERDOTE));

		if (json.has(PacienteKeys.RESP_ATENDIMENTO))
			setRespAtendimento(json.getString(PacienteKeys.RESP_ATENDIMENTO));

		if (json.has(PacienteKeys.DADOS_PESSOAIS))
			setDadosPessoais(json.getJSONObject(PacienteKeys.DADOS_PESSOAIS));

		if (json.has(PacienteKeys.DADOS_FAMILIARES))
			setDadosFamiliares(json.getJSONArray(PacienteKeys.DADOS_FAMILIARES));

		if (json.has(PacienteKeys.DADOS_MORADA))
			setDadosMorada(json.getJSONObject(PacienteKeys.DADOS_MORADA));

		if (json.has(PacienteKeys.DADOS_SAUDE))
			setDadosSaude(json.getJSONObject(PacienteKeys.DADOS_SAUDE));

		if (json.has(PacienteKeys.DADOS_PAROQUIA))
			setDadosParoquia(json.getJSONObject(PacienteKeys.DADOS_PAROQUIA));
	}

	// TODO
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		return json;
	}

	public static class PacienteBuilder {
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

		public PacienteBuilder addNumFicha(int numFicha) {
			this.numFicha = numFicha;
			return this;
		}

		public PacienteBuilder addDataPrimeiroAtend(String dataPrimAtendimento) {
			this.dataPrimeiroAtend = dataPrimAtendimento;
			return this;
		}

		public PacienteBuilder addParoco(String paroco) {
			this.paroco = paroco;
			return this;
		}

		public PacienteBuilder addSacerdote(String sacerdote) {
			this.sacerdote = sacerdote;
			return this;
		}

		public PacienteBuilder addRespAtendimento(String respAtendimento) {
			this.respAtendimento = respAtendimento;
			return this;
		}

		public PacienteBuilder addDadosPessoais(DadosPessoal dadosPessoais) {
			this.dadosPessoais = dadosPessoais;
			return this;
		}

		public PacienteBuilder addDadosFamiliar(DadosFamiliar dadosFamiliar) {
			this.dadosFamiliares.add(dadosFamiliar);
			return this;
		}

		public PacienteBuilder addDadosMorada(DadosMorada dadosMorada) {
			this.dadosMorada = dadosMorada;
			return this;
		}

		public PacienteBuilder addDadosSaude(DadosSaude dadosSaude) {
			this.dadosSaude = dadosSaude;
			return this;
		}

		public PacienteBuilder addDadosParoquias(DadosParoquias dadosParoquias) {
			this.dadosParoquias = dadosParoquias;
			return this;
		}

		public Paciente build() {
			return new Paciente(numFicha, dataPrimeiroAtend, paroco, sacerdote, respAtendimento, dadosPessoais,
					dadosFamiliares, dadosMorada, dadosSaude, dadosParoquias);
		}

	}

}
