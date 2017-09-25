package br.com.naasp.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.naasp.models.Paciente;
import br.com.naasp.repository.PacienteRepository;
import br.com.naasp.service.models.CadastroPacienteResposta;

@Controller
public class PacienteController {

	@Autowired
	private PacienteRepository repository;

	@RequestMapping(value = "Cadastro/paciente", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public @ResponseBody String cadastrarPaciente(@RequestBody String json) throws JSONException {
		boolean erroFlag = true;
		Paciente p = new Paciente(new JSONObject(json));
		repository.save(p);

		CadastroPacienteResposta responseObject = new CadastroPacienteResposta(erroFlag);
		responseObject.setIdPaciente(Integer.toString(p.getId()));
		String response = responseObject.toJson().toString();
		return response;
	}

}
