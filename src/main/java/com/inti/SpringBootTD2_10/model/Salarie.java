package com.inti.SpringBootTD2_10.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
@Generated
public class Salarie
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String nom;
	private String prenom;
	private String email;
	
	public Salarie(@NonNull String nom, String prenom, String email)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	
}
