package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Candidat;
import com.example.demo.service.CandidatService;

import lombok.RequiredArgsConstructor;
import request.CandidatRequest;

@RestController
@RequestMapping("api/vs/candidat")
@RequiredArgsConstructor
public class CandidatController {
	
	private final CandidatService candidatService;
	
	@PostMapping("/add")
	public Candidat addCandidat(CandidatRequest candidat) {
		
		return this.candidatService.addCandidat(candidat);
	}

	@GetMapping("/get")
	public Candidat getCandidat(String id) {
		
		return this.candidatService.getCandidat(id);
	}
}
