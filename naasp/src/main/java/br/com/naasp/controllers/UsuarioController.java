package br.com.naasp.controllers;

import java.util.ArrayList;

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

		Usuario usuario = new Usuario(new JSONObject(json));
		usuario.encriptData();

		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) repository.findAll();
		boolean isLoginOk = usuarios.stream()
				.filter(u -> u.getNome().equals(usuario.getNome()) && u.getSenha().equals(usuario.getSenha()))
				.count() == 1;

		Resposta resposta = new Resposta(isLoginOk);
		if (!isLoginOk)
			resposta.getMensagens().add("login invalido");
		String response = resposta.toJson().toString();
		return response;
	}

}
