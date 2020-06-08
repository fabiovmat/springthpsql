package curso.springboot.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

import curso.springboot.model.Pessoa;
import curso.springboot.repository.PessoaRepository;

@SpringBootTest
class SpringbootApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testeInsert() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Fabio");
		pessoa.setSobrenome("Matt");
		
		//teste
		
		
		
		
		
	}
	
}
