package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Candidat;
import com.example.demo.entity.Vote;
import com.example.demo.repository.IAppUserRepository;
import com.example.demo.repository.ICandidatRepository;
import com.example.demo.repository.IVoteRepository;

import lombok.RequiredArgsConstructor;
import request.VoteRequest;

@Service
@RequiredArgsConstructor
public class VoteService {
	
	private final IAppUserRepository userRepository;
	private final IVoteRepository voteRepository;
	private final ICandidatRepository candidatRepository;
	
	public Vote setVote(VoteRequest voteRequest) {
		
		AppUser user = userRepository.findByNumeroNational(voteRequest.getUserId());
		AppUser candidat = userRepository.findByNumeroNational(voteRequest.getCandidatId());
		Candidat candidat2 = candidatRepository.findByUser(candidat);
		
		var vote = Vote.builder()
				.candidat(candidat2)
				.user(user)
				.build();
		
		
		return voteRepository.save(vote);
		
	}
	
	public Vote getVote(String userNumeroNational) {
		
		AppUser user = userRepository.findByNumeroNational(userNumeroNational);
		return voteRepository.findByUser(user);
	}
	

}
