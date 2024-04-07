package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.entity.AppUser;

@Service
public interface AppUserService {
	
	public AppUser getUser(String numeroNational);
}
