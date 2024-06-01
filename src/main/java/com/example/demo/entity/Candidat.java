package com.example.demo.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@OneToOne()
	private AppUser user;
	private String photo;
	private String projet;
	private String labelParti;
	private String nomParti;
	
	@OneToMany(mappedBy = "candidat", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Vote> vote;
	
	@Override
	public String toString() {
		return "candidat{"
				+ "id = "+this.id
				+ ", user =  "+ this.user
				+ ", projet = "+this.projet
				+ " ,labelParti = "+this.labelParti;
	}

}
