package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AppUser;


public interface IAppUserRepository extends JpaRepository<AppUser, UUID> {
	
	
	AppUser findByNumeroNational(String numero);

}
