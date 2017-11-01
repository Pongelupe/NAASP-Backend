package br.com.naasp.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.naasp.models.Relatorio;
import net.sf.jasperreports.engine.JRException;

@Controller
public class RelatorioController {

	@Autowired
	private DataSource dbsource;

	@RequestMapping(value = "gerarRelatorio", method = org.springframework.web.bind.annotation.RequestMethod.POST, produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody ResponseEntity<InputStreamResource> gerarRelatorio(@RequestBody String json) {
		Relatorio relatorio;

		try {

			relatorio = new Relatorio(new JSONObject(json));
			ByteArrayInputStream stream = relatorio.toByteArrayInputStream(dbsource);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=" + relatorio.getNome());

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(stream));
		} catch (JSONException | IOException | JRException | SQLException e) {
			return null;
		}
	}

}