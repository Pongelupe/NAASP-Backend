package br.com.naasp.models;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class Relatorio {

	private final ArrayList<String> parametros = new ArrayList<String>();
	private String nome;

	private static class RelatorioKeys {

		private static final String PARAMETROS = "parametros";
		private static final String JASPER_FILE_NAME = "NAASP.jasper";
		private static final String JRXML_FILE_NAME = "NAASP.jrxml";
		private static final String JASPER_FILE_PATH = "src/main/resources/static/";
	}

	private void setParametros(JSONArray jsonArray) throws JSONException {
		for (int i = 0; i < jsonArray.length(); i++)
			parametros.add(jsonArray.getString(i));
	}

	public String getNome() {
		return nome;
	}

	public ByteArrayInputStream toByteArrayInputStream(DataSource dataSource)
			throws JRException, SQLException, IOException {

		compileJrxml();

		Map<String, Object> params = new HashMap<String, Object>();
		JasperPrint jasperPrinted = JasperFillManager.fillReport(
				RelatorioKeys.JASPER_FILE_PATH + RelatorioKeys.JASPER_FILE_NAME, params, dataSource.getConnection());
		JRPdfExporter exporter = new JRPdfExporter();
		ByteArrayOutputStream byteArrayOuputStream = new ByteArrayOutputStream();

		File pdf = new File(RelatorioKeys.JASPER_FILE_PATH + nome);

		exporter.setExporterInput(new SimpleExporterInput(jasperPrinted));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdf));

		exporter.exportReport();

		byte[] byteArray = IOUtils.toByteArray(new FileInputStream(pdf));
		byteArrayOuputStream.write(byteArray);

		return new ByteArrayInputStream(byteArrayOuputStream.toByteArray());

	}

	private void compileJrxml() throws JRException {
		JasperCompileManager.compileReportToFile(RelatorioKeys.JASPER_FILE_PATH + RelatorioKeys.JRXML_FILE_NAME);
	}

	public Relatorio(JSONObject json) throws JSONException {
		cleanDir();

		if (json.has(RelatorioKeys.PARAMETROS))
			setParametros(json.getJSONArray(RelatorioKeys.PARAMETROS));

		this.nome = LocalDate.now() + ".pdf";
	}

	private void cleanDir() {
		File folder = new File(RelatorioKeys.JASPER_FILE_PATH);
		List<File> files = Arrays.asList(folder.listFiles());
		files.stream().filter(f -> f.getName().endsWith(".pdf")).forEach(f -> f.delete());
	}

}