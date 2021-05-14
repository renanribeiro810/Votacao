package br.com.teste.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.teste.entities.Pauta;
import br.com.teste.exception.PautaException;
import br.com.teste.repository.PautaRepository;
import br.com.teste.vo.PautaAssociadosNaoVO;
import br.com.teste.vo.PautaVO;

@Service
public class PautaService {
	
	@Autowired
	private PautaRepository pautaRepository;
	
	public List<Pauta> listAll(){
		return pautaRepository.findAll();
	}
	
	public void deleteById(Integer idPauta) {
		pautaRepository.deleteById(idPauta);
	}
	
	public void deleteAll() {
		pautaRepository.deleteAll();
	}
	
	public List<PautaAssociadosNaoVO> listaAssociadosVotoNao(Integer pagina, Integer qtdRegistros){
		Pageable page = null;
		page = PageRequest.of(pagina, qtdRegistros);
		if(null != pagina && null != qtdRegistros) {
			return pautaRepository.listaAssociadosVotoNao(page);
		}
		return pautaRepository.listaAssociadosVotoNao(page);
	}
	

	public String votacao(PautaVO pvo) throws PautaException {
		
		GregorianCalendar start = new GregorianCalendar();
		GregorianCalendar end = new GregorianCalendar();		
		end.add(end.MINUTE, 1);
		Date dataFim = end.getTime();
		Date dataInicio = start.getTime();

		
		while (dataInicio.compareTo(dataFim) <= 0) {
			for(Pauta p : pvo.getListPauta()) {
				Pauta pautaNova = new Pauta();
				if(pautaRepository.verificarVoto(p.getIdAssociado(), p.getVotacao_id()) == false) {
					pautaNova.setVotoSim(p.getVotoSim());
					pautaNova.setIdAssociado(p.getIdAssociado());
					pautaNova.setDataCadastro(new Date());		    	
					pautaNova.setVotoNao(p.getVotoNao());
					pautaNova.setVotacao_id(p.getVotacao_id());
					pautaRepository.save(pautaNova);
				}
		    Date inicio = new Date();
		    dataInicio = inicio;
			}
			
		    
		}
		Integer votoSim = pautaRepository.countVotacaoSim();
		Integer votoNao = pautaRepository.countVotacaoNao();
		return "Votacao Encerrada! Votos para sim: "+votoSim+" Votos para Nao: "+votoNao;
		
	}
	
}
	
	
	
	

