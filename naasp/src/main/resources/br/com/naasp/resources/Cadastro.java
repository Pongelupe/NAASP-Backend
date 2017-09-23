package br.com.naasp.resources;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.naasp.models.Paciente;
import br.com.naasp.resources.model.responses.CadastroPacienteResposta;

@Controller
@RequestMapping(value = "/Cadastro")
public class Cadastro {

	@RequestMapping(value = "/cadastroPaciente", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public String adicionaPaciente(@RequestBody String json) throws JSONException {
		boolean erroFlag = true;
		Paciente paciente = new Paciente(new JSONObject(json));

		paciente.add();

		CadastroPacienteResposta responseObject = new CadastroPacienteResposta(erroFlag);
		responseObject.setIdPaciente(Integer.toString(paciente.getId()));
		String response = responseObject.toJson().toString();
		return response;
	}

}
