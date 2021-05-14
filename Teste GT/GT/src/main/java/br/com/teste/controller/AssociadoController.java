package br.com.teste.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.entities.Associado;
import br.com.teste.exception.AssociadoException;
import br.com.teste.service.AssociadoService;

@RestController
@RequestMapping("/associado")
public class AssociadoController {
	
	@Autowired
	private AssociadoService aService;
	
	@PostMapping("/save")
	public ResponseEntity<Void> save(@Valid @RequestBody Associado a) throws AssociadoException{
		aService.save(a);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
