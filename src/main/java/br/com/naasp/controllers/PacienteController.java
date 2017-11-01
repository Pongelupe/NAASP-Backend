package br.com.naasp.controllers;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.naasp.models.Paciente;
import br.com.naasp.repository.PacienteRepository;
import br.com.naasp.service.models.CadastroAnamneseChamada;
import br.com.naasp.service.models.CadastroPacienteResposta;
import br.com.naasp.service.models.ListarPacienteResposta;
import br.com.naasp.service.models.Resposta;

@Controller
public class PacienteController {

	@Autowired
	private PacienteRepository repository;
	@Autowired
	private EntityManager manager;

	@RequestMapping(value = "Cadastro/paciente", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public @ResponseBody String cadastrarPaciente(@RequestBody String json) {
		Paciente paciente;
		try {
			paciente = new Paciente(new JSONObject(json));
			repository.save(paciente);

			CadastroPacienteResposta responseObject = new CadastroPacienteResposta(false);
			responseObject.setIdPaciente(Integer.toString(paciente.getId()));
			String response = responseObject.toJson().toString();
			return response;
		} catch (Exception e) {
			CadastroPacienteResposta responseObject = new CadastroPacienteResposta(true);
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

	@RequestMapping(value = "Cadastro/anamnese", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public @ResponseBody String cadastrarAnamnese(@RequestBody String json) {

		try {
			CadastroAnamneseChamada request = new CadastroAnamneseChamada(new JSONObject(json));
			Paciente paciente = repository.findOne(request.getIdPaciente());
			paciente.addAnamnese(request.getAnamnse());
			repository.save(paciente);

			Resposta response = new Resposta(false);
			return response.toJson().toString();
		} catch (JSONException e) {
			Resposta response = new Resposta(true);
			response.setMensagem(e.toString());
			return response.toJson().toString();
		}

	}

}
