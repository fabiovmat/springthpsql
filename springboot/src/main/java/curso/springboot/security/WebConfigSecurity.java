package curso.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ImplementacaoUserDetailService implementacaoUserDetailService;
	
	@Override //configura solicitacoes de acesso por http
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		.disable()//Desativa  configuracoes padroes de memoria
		.authorizeRequests() //permitir restringir acesso
		.antMatchers(HttpMethod.GET,"/").permitAll() //qualquer user acessar a pagina inicial
		.antMatchers(HttpMethod.GET,"/cadastropessoa").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().permitAll()//permite qualquer usuario
		.loginPage("/login")
		.defaultSuccessUrl("/cadastropessoa")
		.failureUrl("/login?error=true")
		.and().logout().logoutSuccessUrl("/login") //mapeia URL de Logout e invalida usuario autenticado
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	@Override //cria autenticacao do usuario com banco de dados ou em memoria
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		
		auth.userDetailsService(implementacaoUserDetailService) //adiciona implementacao do UserDetailService
		.passwordEncoder(new BCryptPasswordEncoder());
		
		
		
		
		/*
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
		.withUser("Admin")
		.password("$2a$10$To.b/MvAxxurRpdnJgURzOqVsnvJhyMT7IxLammZagUHoeTYojSGe")
		.roles("ADMIN");
		*/
	}
	
	@Override // ignora Urls especificas
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/materialize/**");//libera o conteudo css materialize para acesso total
		
	}
}
