package br.com.teste.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.teste.entities.Pauta;
import br.com.teste.vo.PautaAssociadosNaoVO;

@Repository
public interface PautaRepository extends JpaRepository<Pauta,Integer>{

	@Query(value = "select count(p)>0 from pauta p "
			+ "where p.pauta_id_associado = :idAssociado "
			+ "and p.votacao_id = :idVotacao",nativeQuery= true)
	Boolean verificarVoto(Integer idAssociado, Integer idVotacao);
	
	@Query(value= "select count(p) from pauta p where pauta_voto_nao = 'nao' \r\n"
			+ "and p.votacao_id = (select max(p.votacao_id) from pauta p)",nativeQuery= true)
	Integer countVotacaoNao();
	
	@Query(value= "select count(p) from pauta p where pauta_voto_sim = 'sim' \r\n"
			+ "and p.votacao_id = (select max(p.votacao_id) from pauta p)",nativeQuery= true)
	Integer countVotacaoSim();
	
	@Query(value = "select \r\n"
			+ "(select a.associado_nome from associado a where p.pauta_id_associado = a.associado_id) as Nome,\r\n"
			+ "p.pauta_id_associado as IdAssociado,\r\n"
			+ "cast(p.pauta_data_cadastro as varchar(10)) as dataVotacao\r\n"
			+ "from pauta p where p.pauta_voto_nao = 'nao'", nativeQuery = true)
	List<PautaAssociadosNaoVO> listaAssociadosVotoNao(Pageable page);
}
