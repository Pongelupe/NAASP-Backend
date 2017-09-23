package br.com.naasp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.naasp.models.Paciente;
import br.com.naasp.service.models.CadastroPacienteResposta;

@Controller
public class PacienteController {

	// @Autowired
	// private PacienteDAO pacienteDAO;

	@RequestMapping(value = "Cadastro/paciente", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public @ResponseBody Object cadastrarPaciente(@RequestBody Paciente p) {
		boolean erroFlag = true;
		// pacienteDAO.gravar(p);

		CadastroPacienteResposta responseObject = new CadastroPacienteResposta(erroFlag);
		responseObject.setIdPaciente(Integer.toString(p.getId()));
		String response = responseObject.toJson().toString();
		return response;
	}

}
