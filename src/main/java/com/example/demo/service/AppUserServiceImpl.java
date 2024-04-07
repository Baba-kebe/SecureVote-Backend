package com.example.demo.service;



import org.springframework.stereotype.Service;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.IAppUserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AppUserServiceImpl implements AppUserService {
	
	private final IAppUserRepository appUserRepository;

	@Override
	public AppUser getUser(String numeroNational) {
		// TODO Auto-generated method stub
		return this.appUserRepository.findByNumeroNational(numeroNational);
	}

}
