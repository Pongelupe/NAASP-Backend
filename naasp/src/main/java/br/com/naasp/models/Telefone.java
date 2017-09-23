package br.com.naasp.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int telefoneId;

	public String telefones;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pessoa")
	private DadosPessoal dadosPessoal;

	public Telefone() {
	}
}