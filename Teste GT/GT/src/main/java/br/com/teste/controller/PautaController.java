package br.com.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.entities.Pauta;
import br.com.teste.exception.PautaException;
import br.com.teste.service.PautaService;
import br.com.teste.vo.PautaAssociadosNaoVO;
import br.com.teste.vo.PautaVO;

@RestController
@RequestMapping("/pauta")
public class PautaController {
	
	@Autowired
	private PautaService pautaService;
	
	@GetMapping("listAll")
	public List<Pauta> listAll(){
		return pautaService.listAll();
	}
	
	@DeleteMapping("/delete-by-id/{idPauta}")
	public void deleteById(@PathVariable Integer idPauta) {
		pautaService.deleteById(idPauta);
	}
	
	@PostMapping("/votacao")
	public String votacao(@RequestBody PautaVO pvo) throws PautaException {
		return pautaService.votacao(pvo);
	}
	
	@GetMapping("/list-associado-voto-nao")
	public List<PautaAssociadosNaoVO> listaAssociadosVotoNao(@RequestParam(required=false) Integer pagina,
			@RequestParam(required=false) Integer qtdRegistros){
		return pautaService.listaAssociadosVotoNao(pagina,qtdRegistros);
	}
	
	@DeleteMapping("/delete-all")
	public void deleteAll() {
		pautaService.deleteAll();
	}
}
