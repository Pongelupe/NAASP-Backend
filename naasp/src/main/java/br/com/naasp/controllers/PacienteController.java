package br.com.naasp.controllers;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.naasp.models.Paciente;
import br.com.naasp.repository.PacienteRepository;
import br.com.naasp.service.models.CadastroPacienteResposta;
import br.com.naasp.service.models.ListarPacienteResposta;

@Controller
public class PacienteController {

	@Autowired
	private PacienteRepository repository;
	@Autowired
	private EntityManager manager;

	@RequestMapping(value = "Cadastro/paciente", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public @ResponseBody String cadastrarPaciente(@RequestBody String json) {
		Paciente p;
		try {
			p = new Paciente(new JSONObject(json));
			repository.save(p);

			CadastroPacienteResposta responseObject = new CadastroPacienteResposta(true);
			responseObject.setIdPaciente(Integer.toString(p.getId()));
			String response = responseObject.toJson().toString();
			return response;
		} catch (Exception e) {
			CadastroPacienteResposta responseObject = new CadastroPacienteResposta(false);
			responseObject.setMensagem(e.toString());
			return responseObject.toJson().toString();
		}
	}

	@RequestMapping(value = "listarPacientes", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public @ResponseBody String listarPacientes() {
		manager.clear();
		ArrayList<Paciente> pacientes = (ArrayList<Paciente>) repository.findAll();
		ListarPacienteResposta responseObject = new ListarPacienteResposta(true, pacientes);
		return responseObject.toJson().toString();
	}

}
