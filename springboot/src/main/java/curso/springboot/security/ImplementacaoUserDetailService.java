package curso.springboot.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import curso.springboot.model.Usuario;
import curso.springboot.repository.UsuarioRepository;


@Service
@Transactional
public class ImplementacaoUserDetailService implements UserDetailsService {
	
	
	@Autowired //injecao de dependencia
	private UsuarioRepository usuarioRepository;//consulta no banco

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findUserByLogin(username);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario não foi encontrado"); //imprime no console caso nao tenha usuario
		}
		
		return new User(usuario.getLogin(), usuario.getPassword(), usuario.isEnabled(),true, true, true, usuario.getAuthorities());
	}

}
