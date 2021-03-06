package com.i9developed.oauth2.ws.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.i9developed.oauth2.ws.domain.Role;
import com.i9developed.oauth2.ws.domain.User;
import com.i9developed.oauth2.ws.repositories.RoleRepository;
import com.i9developed.oauth2.ws.repositories.UserRepository;
import com.i9developed.oauth2.ws.repositories.VerificationTokenRepository;

@Configuration
@Profile("dev2")
public class Instantiation implements CommandLineRunner  {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		roleRepository.deleteAll();
		verificationTokenRepository.deleteAll();
		
		Role roleAdmin = new Role("ROLE_ADMIN");
		Role roleUser = new Role("ROLE_USER");
		
		roleRepository.saveAll(Arrays.asList(roleAdmin,roleUser));
		
		
		
		User moises = new User("Moises","Rodrigues de souza","moises.souza@gmail.com");
		User maria = new User("Ana","Maria","ana.maria@gmail.com");
		 User joao = new User("João", "Souza", "joao@gmail.com");
		 User maria2 = new User("Maria", "Teixeira", "maria@gmail.com");
		 
		 User moisesj = new User("Moises","Rodrigues de souza Junior","moises.souza@al.infnet.edu.br");
		 
		 moises.getRoles().addAll(Arrays.asList(roleAdmin,roleUser));
		 moises.setPassword(passwordEncoder.encode("123456"));
		 moises.setEnable(true);
		 
		 moisesj.getRoles().addAll(Arrays.asList(roleAdmin,roleUser));
		 moisesj.setPassword(passwordEncoder.encode("654321"));
		 moisesj.setEnable(true);
		 
		 maria.getRoles().addAll(Arrays.asList(roleAdmin,roleUser));
		 maria.setPassword(passwordEncoder.encode("123456"));
		 maria.setEnable(true);
		 
		 
		 
		 joao.getRoles().addAll(Arrays.asList(roleUser));
		 joao.setPassword(passwordEncoder.encode("123456"));
		 joao.setEnable(true);
		 
		 maria2.getRoles().addAll(Arrays.asList(roleUser));
		 maria2.setPassword(passwordEncoder.encode("123456"));
		 maria2.setEnable(true);
		 
		userRepository.saveAll(Arrays.asList(moises,maria,maria2,joao,moisesj));
	}

}
