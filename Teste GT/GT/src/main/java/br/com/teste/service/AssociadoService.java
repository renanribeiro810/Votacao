package br.com.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.teste.entities.Associado;
import br.com.teste.exception.AssociadoException;
import br.com.teste.repository.AssociadoRepository;

@Service
public class AssociadoService {
	
	@Autowired
	private AssociadoRepository aRepository;
	
	public Associado save(Associado a) throws AssociadoException {
		Boolean resp = valida(a.getAssociadoCPF());
		if(resp == true){
			return aRepository.save(a);
		}else {
			throw new AssociadoException("CPF Invalido");
		}
	}
	
	public static boolean valida(String cpf) { 
	    CPFValidator cpfValidator = new CPFValidator(); 
	    try{ cpfValidator.assertValid(cpf); 
	    return true; 
	    }catch(Exception e){ 
	        e.printStackTrace(); 
	        return false; 
	        } 
	    }
	
}
