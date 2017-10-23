package br.com.naasp.models;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import net.sf.jasperreports.engine.JRException;
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
		private static final String JASPER_FILE_NAME = "Simple_Blue.jasper";
		// private static final String JASPER_FILE_PATH = System.getProperty("user.dir")
		// + "/src/main/resources/";
		private static final String JASPER_FILE_PATH = "src/main/resources/";
	}

	private void setParametros(JSONArray jsonArray) throws JSONException {
		for (int i = 0; i < jsonArray.length(); i++)
			parametros.add(jsonArray.getString(i));
	}

	public String getNome() {
		return nome;
	}

	public File toFile(DataSource dataSource) throws JRException, SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		JasperPrint jasperPrinted = JasperFillManager.fillReport(
				RelatorioKeys.JASPER_FILE_PATH + RelatorioKeys.JASPER_FILE_NAME, params, dataSource.getConnection());
		JRPdfExporter exporter = new JRPdfExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrinted));
		File pdf = new File(RelatorioKeys.JASPER_FILE_PATH + nome);
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdf));

		exporter.exportReport();

		return pdf;
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