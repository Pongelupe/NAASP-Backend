package br.com.naasp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
public class Voluntario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idVoluntario;

	private int idade;
	private String telefone;
	private String email;
	private String especialiade;

	private static class VoluntarioKeys {
		public static final String ID = "idVoluntario";
		public static final String TELEFONE = "telefone";
		public static final String EMAIL = "email";
		public static final String IDADE = "idade";
		public static final String ESPECIALIADE = "especialiade";
	}

	public Voluntario(JSONObject json) throws JSONException {
		if (json.has(VoluntarioKeys.EMAIL))
			setEmail(json.getString(VoluntarioKeys.EMAIL));

		if (json.has(VoluntarioKeys.TELEFONE))
			setTelefone(json.getString(VoluntarioKeys.TELEFONE));

		if (json.has(VoluntarioKeys.IDADE))
			setIdade(json.getInt(VoluntarioKeys.IDADE));
	}

	@Deprecated
	public Voluntario() {
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEspecialiade() {
		return especialiade;
	}

	public void setEspecialiade(String especialiade) {
		this.especialiade = especialiade;
	}

	public int getIdVoluntario() {
		return idVoluntario;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		try {
			json.put(VoluntarioKeys.ID, idVoluntario);
			json.put(VoluntarioKeys.EMAIL, email);
			json.put(VoluntarioKeys.TELEFONE, telefone);
			json.put(VoluntarioKeys.IDADE, idade);
			json.put(VoluntarioKeys.ESPECIALIADE, especialiade);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return json;

	}

}
