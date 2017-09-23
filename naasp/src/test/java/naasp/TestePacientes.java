package naasp;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.naasp.models.DadosFamiliar;
import br.com.naasp.models.DadosMorada;
import br.com.naasp.models.DadosParoquias;
import br.com.naasp.models.DadosPessoal;
import br.com.naasp.models.Paciente;
import br.com.naasp.models.Paciente.PacienteBuilder;

/**
 * Servlet implementation class Pacientes
 */
@Controller
@RequestMapping(value = "/")
public class TestePacientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource
	private UserTransaction ut;

	@PersistenceContext
	private EntityManager em;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PacienteBuilder builder = new Paciente.PacienteBuilder();
		builder.addDadosFamiliar(new DadosFamiliar("pai", "dev cabuloso", null, 12))
				.addDadosMorada(new DadosMorada(null, null)).addDadosPessoais(new DadosPessoal())
				.addDadosParoquias(new DadosParoquias(null, null, null, null, null));

		Paciente p = builder.build();

		try {
			ut.begin();
			em.persist(p);
			ut.commit();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		response.getWriter().append("Paciente criado com id = " + p.getId() + "\n" + p.toString());
	}

}