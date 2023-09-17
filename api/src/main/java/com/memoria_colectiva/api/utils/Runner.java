package com.memoria_colectiva.api.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.memoria_colectiva.api.models.dao.AuthorityRepository;
import com.memoria_colectiva.api.models.dao.UsuarioRepository;
import com.memoria_colectiva.api.models.entity.Authority;
import com.memoria_colectiva.api.models.entity.Usuario;

@Component
public class Runner  implements CommandLineRunner{

	private final AuthorityRepository authRepository;
	private final UsuarioRepository usuarioRepository;
	

    // private Logger logger = LoggerFactory.getLogger(Runner.class);
	
	public Runner(AuthorityRepository authRepository, UsuarioRepository usuarioRepository) {
		this.authRepository = authRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		if(this.authRepository.count()==0) {
			try {
				
				this.authRepository.saveAll(List.of(
						new Authority(AuthorityName.ADMIN),
						new Authority(AuthorityName.READ),
						new Authority(AuthorityName.WRITE)
				));
			} catch (Exception e) {
				throw e;
			}
		}
		
		if(this.usuarioRepository.count()==0) {
			this.usuarioRepository.saveAll(List.of(
					new Usuario("darus", "Caradej1", List.of(this.authRepository.findByName(AuthorityName.ADMIN).get())),
					new Usuario("cindy", "leronardo22", List.of(this.authRepository.findByName(AuthorityName.WRITE).get())),
					new Usuario("anais", "123", List.of(this.authRepository.findByName(AuthorityName.READ).get()))
			));
		}
	}

}
