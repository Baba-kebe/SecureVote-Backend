package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Candidat;
import com.example.demo.service.CandidatService;

import lombok.RequiredArgsConstructor;
import request.CandidatRequest;

@RestController
@RequestMapping("/api/vs/candidat")
@RequiredArgsConstructor
public class CandidatController {
	
	private final CandidatService candidatService;
	
	@PostMapping("/add")
	public Candidat addCandidat(@RequestBody CandidatRequest candidat) {
		return this.candidatService.addCandidat(candidat);
	}
	
	@GetMapping("/getCandidat")
	public Candidat getCandidat(@RequestParam("id") String id) {
		
		return this.candidatService.getCandidat(id);
	}
	
	@GetMapping("/getCandidats")
	public List<Candidat> test() {
		return this.candidatService.getAll();
	}
	
	
	
}
