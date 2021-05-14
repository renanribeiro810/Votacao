package br.com.teste.vo;

import java.io.Serializable;
import java.util.List;

import br.com.teste.entities.Pauta;

public class PautaVO implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private List<Pauta> ListPauta;
	
	
	
	public List<Pauta> getListPauta() {
		return ListPauta;
	}
	public void setListPauta(List<Pauta> listPauta) {
		ListPauta = listPauta;
	}

	
	

}
