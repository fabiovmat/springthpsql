package curso.springboot.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.springboot.model.Profissao;



@Repository
@Transactional
public interface ProfisssaoRepository extends CrudRepository<Profissao, Long>  {

	
	
	//@Query("select t from Profissao t where t.profissao.id = ?1")	
	   //public List<Profissao> getNome(Long profissaoId);
	
	
}
