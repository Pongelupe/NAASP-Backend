package br.com.naasp.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.naasp.models.Usuario;
import br.com.naasp.repository.UsuarioRepository;
import br.com.naasp.service.models.Resposta;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@RequestMapping(value = "login", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public @ResponseBody String login(@RequestBody String json) throws JSONException {

		Usuario usuarioRequest = new Usuario(new JSONObject(json));
		usuarioRequest.encriptData();

		Usuario usuario = repository.getLogin(usuarioRequest.getNome());

		boolean isLoginOk = usuario != null ? usuarioRequest.getSenha().equals(usuario.getSenha()) : false;

		Resposta resposta = new Resposta(isLoginOk);
		if (!isLoginOk)
			resposta.getMensagens().add("login invalido");
		String response = resposta.toJson().toString();
		return response;
	}

}
