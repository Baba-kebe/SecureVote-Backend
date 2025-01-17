package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Vote;
import com.example.demo.service.VoteService;

import lombok.RequiredArgsConstructor;
import request.VoteRequest;

@RestController
@RequestMapping("/api/vs/vote")
@RequiredArgsConstructor
public class VoteController {
	
	private final VoteService voteService;
	
	@PostMapping("/savevote")
	public Vote saveVote(@RequestBody VoteRequest vote) {
		
		return voteService.setVote(vote);
	}
	
	@GetMapping("/getVote")
	public Vote getVote(@RequestBody String userNumeroNational) {
		
		return voteService.getVote(userNumeroNational);
	}
	
	

}
