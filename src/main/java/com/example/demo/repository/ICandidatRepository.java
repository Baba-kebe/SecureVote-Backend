package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Candidat;


public interface ICandidatRepository extends JpaRepository<Candidat, UUID> {
	
	Candidat findByUser(AppUser user);

}
