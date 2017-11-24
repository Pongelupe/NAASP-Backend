package br.com.naasp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.naasp.models.Voluntario;

@Repository
public interface VoluntarioRepository extends CrudRepository<Voluntario, Integer> {

}
