package curso.springboot.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import curso.springboot.model.Pessoa;


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
		pessoa.setIdade(37);
		
		//teste
		
		
		
		
		
	}
	
}
