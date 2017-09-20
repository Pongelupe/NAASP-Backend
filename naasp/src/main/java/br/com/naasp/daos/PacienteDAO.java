package br.com.naasp.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.naasp.models.Paciente;

@Transactional
@Repository
public class PacienteDAO {

	@PersistenceContext
	private static EntityManager manager;

	public static void gravar(Paciente paciente) {
		manager.persist(paciente);
	}

}
