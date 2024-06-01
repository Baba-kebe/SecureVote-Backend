package com.example.demo.auth;

import java.time.LocalDate;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.JwtService;
import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.repository.IAppUserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final IAppUserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest request) {
		// TODO Auto-generated method stub
		var user = AppUser.builder()
				.nom(request.getNom())
				.adresse(request.getAdresse())
				.birthDate(LocalDate.parse(request.getBirthDate()))
				.prenom(request.getPrenom())
				.sexe(request.getSexe())
				.hasVoted(false)
				.numeroNational(request.getNumeroNational())
				.numeroTelephone(request.getNumeroTelephone())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.ELECTEUR)
				.build();
		
		repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		// TODO Auto-generated method stub
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNumeroNational(), request.getPassword()));
		var user = repository.findByNumeroNational(request.getNumeroNational());
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
	
	

}
