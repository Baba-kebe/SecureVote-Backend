package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Candidat;
import com.example.demo.entity.Vote;


public interface IVoteRepository extends JpaRepository<Vote, UUID>{

	Vote findByUser(AppUser user);
	List<Vote> findByCandidat(Candidat candidat);
}
