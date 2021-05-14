package br.com.teste.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "associado")
public class Associado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="associado_id")
	private Integer idAssociado;
	
	@Column(name="associado_nome")
	private String nome;
	
	@Column(name="associado_cpf")
	private String associadoCPF;
	
	public Associado() {}

	
	
	public String getAssociadoCPF() {
		return associadoCPF;
	}



	public void setAssociadoCPF(String associadoCPF) {
		this.associadoCPF = associadoCPF;
	}



	public Integer getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Integer idAssociado) {
		this.idAssociado = idAssociado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
