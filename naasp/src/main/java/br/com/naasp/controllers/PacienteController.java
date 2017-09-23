package br.com.naasp.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.naasp.daos.PacienteDAO;
import br.com.naasp.models.DadosFamiliar;
import br.com.naasp.models.DadosMorada;
import br.com.naasp.models.DadosParoquias;
import br.com.naasp.models.DadosPessoal;
import br.com.naasp.models.Paciente;
import br.com.naasp.models.Paciente.PacienteBuilder;
import br.com.naasp.service.models.CadastroPacienteResposta;

@Controller
public class PacienteController {

	@Autowired
	private PacienteDAO pacienteDAO;

	@RequestMapping(value = "Cadastro/paciente", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public @ResponseBody String cadastrarPaciente(@RequestBody JSONObject json) throws JSONException {
		boolean erroFlag = true;
		Paciente p = new Paciente(json);
		// pacienteDAO.gravar(p);

		CadastroPacienteResposta responseObject = new CadastroPacienteResposta(erroFlag);
		responseObject.setIdPaciente(Integer.toString(p.getNumFicha()));
		String response = responseObject.toJson().toString();
		return response;
	}

	@RequestMapping(value = "cadastro")
	public void cadastrarPaciente() {

		PacienteBuilder builder = new Paciente.PacienteBuilder();
		builder.addDadosFamiliar(new DadosFamiliar("pai", "dev cabuloso", null, 12))
				.addDadosMorada(new DadosMorada(null, null)).addDadosPessoais(new DadosPessoal())
				.addDadosParoquias(new DadosParoquias(null, null, null, null, null));

		Paciente p = builder.build();

		pacienteDAO.gravar(p);

	}

}
