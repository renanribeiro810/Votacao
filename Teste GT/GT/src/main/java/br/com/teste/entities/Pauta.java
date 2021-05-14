package br.com.teste.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pauta")
public class Pauta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pauta_id")
	private Integer idPauta;
	
	@Column(name="pauta_voto_sim")
	private String votoSim;
	
	@Column(name="pauta_voto_nao")
	private String votoNao;
	
	@Column(name = "pauta_id_associado")
	private Integer idAssociado;
	
	@Column(name = "pauta_data_cadastro")
	private Date dataCadastro;
	
	@Column(name = "votacao_id")
	private Integer votacao_id;
	
	public Pauta() {}

	
	
	public Integer getVotacao_id() {
		return votacao_id;
	}



	public void setVotacao_id(Integer votacao_id) {
		this.votacao_id = votacao_id;
	}



	public Date getDataCadastro() {
		return dataCadastro;
	}



	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}



	public Integer getIdAssociado() {
		return idAssociado;
	}



	public void setIdAssociado(Integer idAssociado) {
		this.idAssociado = idAssociado;
	}



	public Integer getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Integer idPauta) {
		this.idPauta = idPauta;
	}

	public String getVotoSim() {
		return votoSim;
	}

	public void setVotoSim(String votoSim) {
		this.votoSim = votoSim;
	}

	public String getVotoNao() {
		return votoNao;
	}

	public void setVotoNao(String votoNao) {
		this.votoNao = votoNao;
	}
	
	

}
