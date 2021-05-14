package br.com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.entities.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado,Integer>{

}
