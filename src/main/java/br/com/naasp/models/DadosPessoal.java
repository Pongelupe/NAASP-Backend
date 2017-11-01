package br.com.naasp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Entity
public class DadosPessoal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pessoalId;

	private String nome;
	private String dataNascimento;
	private char sexo;
	private String estadoCivil;
	private String religiao;
	private String rg;
	private String cpf;
	private String escolaridade;
	private String endereco;
	private String pontoRef;
	private String profissao;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa")
	private List<Telefone> telefones = new ArrayList<Telefone>();

	private static class DadosPessoalKeys {
		public static final String NOME = "nome";
		public static final String DATA_NASCIMENTO = "dataNascimento";
		public static final String SEXO = "sexo";
		public static final String ESTADO_CIVIL = "estadoCivil";
		public static final String RELIGIAO = "religiao";
		public static final String RG = "rg";
		public static final String CPF = "cpf";
		public static final String ESCOLARIDADE = "escolaridade";
		public static final String PONTO_REF = "pontoRe";
		public static final String ENDERECO = "endereco";
		public static final String PROFISSAO = "profissao";
		public static final String TELEFONES = "telefones";
		public static final String ID = "idPessoa";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getReligiao() {
		return religiao;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPontoRef() {
		return pontoRef;
	}

	public void setPontoRef(String pontoRef) {
		this.pontoRef = pontoRef;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	private void setTelefones(JSONArray jsonArray) throws JSONException {
		telefones = new ArrayList<Telefone>();

		for (int i = 0; i < jsonArray.length(); i++)
			telefones.add(new Telefone(jsonArray.getString(i)));
	}

	@Deprecated
	public DadosPessoal() {
	}

	public DadosPessoal(String nome, String dataNascimento, char sexo, String estadoCivil, String religiao, String rg,
			String cpf, String escolaridade, String endereco, String pontoRef, String profissao,
			List<Telefone> telefones) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.profissao = profissao;
		this.religiao = religiao;
		this.rg = rg;
		this.cpf = cpf;
		this.escolaridade = escolaridade;
		this.endereco = endereco;
		this.pontoRef = pontoRef;
		this.telefones = telefones;
	}

	DadosPessoal(JSONObject json) throws JSONException {
		if (json.has(DadosPessoalKeys.NOME))
			nome = json.getString(DadosPessoalKeys.NOME);
		else
			throw new JSONException("missing " + DadosPessoalKeys.NOME);

		if (json.has(DadosPessoalKeys.DATA_NASCIMENTO))
			dataNascimento = json.getString(DadosPessoalKeys.DATA_NASCIMENTO);
		else
			throw new JSONException("missing " + DadosPessoalKeys.DATA_NASCIMENTO);

		if (json.has(DadosPessoalKeys.SEXO))
			sexo = json.getString(DadosPessoalKeys.SEXO).charAt(0);
		else
			throw new JSONException("missing " + DadosPessoalKeys.SEXO);

		if (json.has(DadosPessoalKeys.ESTADO_CIVIL))
			estadoCivil = json.getString(DadosPessoalKeys.ESTADO_CIVIL);
		else
			throw new JSONException("missing " + DadosPessoalKeys.ESTADO_CIVIL);

		if (json.has(DadosPessoalKeys.RELIGIAO))
			religiao = json.getString(DadosPessoalKeys.RELIGIAO);
		else
			throw new JSONException("missing " + DadosPessoalKeys.RELIGIAO);

		if (json.has(DadosPessoalKeys.RG))
			rg = json.getString(DadosPessoalKeys.RG);

		if (json.has(DadosPessoalKeys.CPF))
			cpf = json.getString(DadosPessoalKeys.CPF);

		if (json.has(DadosPessoalKeys.ESCOLARIDADE))
			escolaridade = json.getString(DadosPessoalKeys.ESCOLARIDADE);
		else
			throw new JSONException("missing " + DadosPessoalKeys.ESCOLARIDADE);

		if (json.has(DadosPessoalKeys.PONTO_REF))
			pontoRef = json.getString(DadosPessoalKeys.PONTO_REF);

		if (json.has(DadosPessoalKeys.ENDERECO))
			endereco = json.getString(DadosPessoalKeys.ENDERECO);
		else
			throw new JSONException("missing " + DadosPessoalKeys.ENDERECO);

		if (json.has(DadosPessoalKeys.PROFISSAO))
			profissao = json.getString(DadosPessoalKeys.PROFISSAO);
		else
			profissao = "NÃO POSSUI";

		if (json.has(DadosPessoalKeys.TELEFONES))
			setTelefones(json.getJSONArray(DadosPessoalKeys.TELEFONES));
	}

	@Override
	public String toString() {
		return "DadosPessoal [pessoalId=" + pessoalId + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", sexo=" + sexo + ", estadoCivil=" + estadoCivil + ", religiao=" + religiao + ", rg=" + rg + ", cpf="
				+ cpf + ", escolaridade=" + escolaridade + ", endereco=" + endereco + ", pontoRef=" + pontoRef
				+ ", profissao=" + profissao + ", telefones=" + telefones + "]";
	}

	public JSONObject toJson() throws JSONException {
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		json.put(DadosPessoalKeys.ID, pessoalId);
		json.put(DadosPessoalKeys.NOME, nome);
		json.put(DadosPessoalKeys.DATA_NASCIMENTO, dataNascimento);
		json.put(DadosPessoalKeys.SEXO, sexo);
		json.put(DadosPessoalKeys.ESTADO_CIVIL, estadoCivil);
		json.put(DadosPessoalKeys.RELIGIAO, religiao);
		json.put(DadosPessoalKeys.RG, rg);
		json.put(DadosPessoalKeys.CPF, cpf);
		json.put(DadosPessoalKeys.ESCOLARIDADE, escolaridade);
		json.put(DadosPessoalKeys.ENDERECO, endereco);
		json.put(DadosPessoalKeys.PONTO_REF, pontoRef);
		json.put(DadosPessoalKeys.PROFISSAO, profissao);

		telefones.forEach(t -> jsonArray.put(t.toJson()));
		json.put(DadosPessoalKeys.TELEFONES, jsonArray);

		return json;
	}

}