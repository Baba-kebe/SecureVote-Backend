package com.example.demo.auth;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

	private String nom;
	private String prenom;
	private String password;
	private String birthDate;
	private String adresse;
	private String numeroNational;
	private String numeroTelephone;
	private String sexe;
	
}
