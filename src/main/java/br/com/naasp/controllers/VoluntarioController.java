package br.com.naasp.controllers;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.naasp.models.Voluntario;
import br.com.naasp.repository.VoluntarioRepository;
import br.com.naasp.service.models.CadastroVoluntarioResposta;
import br.com.naasp.service.models.ListarVoluntariosResposta;

@Controller
public class VoluntarioController {

	@Autowired
	private VoluntarioRepository repository;

	@PostMapping(value = "voluntario")
	public @ResponseBody String cadastrarVoluntario(@RequestBody String json) {

		CadastroVoluntarioResposta responseObject = new CadastroVoluntarioResposta(false);
		try {
			Voluntario voluntario = new Voluntario(new JSONObject(json));
			repository.save(voluntario);

			responseObject.setIdVoluntario(Integer.toString(voluntario.getIdVoluntario()));
		} catch (JSONException e) {
			responseObject.setErro(true);
			responseObject.setMensagem(e.toString());
		}

		return responseObject.toJson().toString();
	}

	@GetMapping(value = "voluntario")
	public @ResponseBody String listarVoluntarios() {
		ArrayList<Voluntario> voluntarios = (ArrayList<Voluntario>) repository.findAll();

		return new ListarVoluntariosResposta(false, voluntarios).toJson().toString();
	}

}
