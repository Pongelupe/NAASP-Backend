package br.com.naasp.resources;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.naasp.resources.model.responses.CadastroPacienteResposta;

@RequestMapping(value = "/Cadastro")
public class Cadastro {

	@RequestMapping(value = "/cadastroPaciente", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public String adicionaPaciente(@RequestBody String paciente) {
		boolean erroFlag = true;

		CadastroPacienteResposta responseObject = new CadastroPacienteResposta(erroFlag);
		responseObject.setIdPaciente("312wdqe");
		String response = responseObject.toJson().toString();
		return response;
	}

}
