package br.com.naasp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.naasp.models.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer> {

}
