package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Candidat;
import com.example.demo.entity.Role;
import com.example.demo.repository.IAppUserRepository;
import com.example.demo.repository.ICandidatRepository;

import lombok.RequiredArgsConstructor;
import request.CandidatRequest;

@Service
@RequiredArgsConstructor
public class CandidatService {
	
	private final IAppUserRepository userRepository;
	private final ICandidatRepository candidatRepository;
	
	public Candidat addCandidat(CandidatRequest candidatRequest) {
		AppUser user = userRepository.findByNumeroNational(candidatRequest.getUserId());
		user.setRole(Role.CANDIDAT);
		
		userRepository.save(user);
		
		var candidat = Candidat.builder()
				.photo(candidatRequest.getImage())
				.user(user)
				.labelParti(candidatRequest.getLabelParti())
				.nomParti(candidatRequest.getNomParti())
				.projet(candidatRequest.getProjet())
				.build();
		return this.candidatRepository.save(candidat);
	}
	
	public Candidat getCandidat(String numeroNational) {
		
		AppUser user = userRepository.findByNumeroNational(numeroNational);
		
		return this.candidatRepository.findByUser(user);
	}

	public List<Candidat> getAll() {
		// TODO Auto-generated method stub
		return this.candidatRepository.findAll();
	}
	

}
