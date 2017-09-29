package br.com.naasp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.naasp.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query("select u from Usuario u where u.nome = ?")
	public Usuario getLogin(String login);

}
