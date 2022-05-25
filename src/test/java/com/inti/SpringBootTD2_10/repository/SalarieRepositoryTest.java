package com.inti.SpringBootTD2_10.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.inti.SpringBootTD2_10.model.Salarie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //
public class SalarieRepositoryTest
{
	@Autowired
	SalarieRepository salarieRepository;
	
	Salarie salarie, salarie2;
	
	@BeforeEach
	public void setUp()
	{
		salarie = new Salarie();
		salarie2 = new Salarie("Toto", "Titi", "tt@gmail.com");
	}
	
	@Test
	public void testSaveSalarie()
	{
		//Given
		
		
		//When : dans quelle situation on va être ? quelle action on va réaliser ? quel est l'objectif ?
		Salarie savedSalarie =  salarieRepository.save(salarie2);
		
		//Then
		assertThat(savedSalarie).isNotNull();
		assertThat(savedSalarie.getId()).isGreaterThan(1);
	}
	
	@Test
	public void testGetSalarie()
	{
		//Given
		
		//When récupère en BDD
		Salarie toGetSalarie = salarieRepository.getReferenceById(2);
		//Then
		assertThat(toGetSalarie).isNotNull();
		assertThat(toGetSalarie.getId()).isEqualTo(2);
		assertThat(toGetSalarie.getNom()).isEqualTo("Pierre");
		assertThat(toGetSalarie.getPrenom()).isEqualTo("Robinou");
		assertThat(toGetSalarie.getEmail()).isEqualTo("b@b.com");
	}
	
	@Test
	@Transactional(value = TxType.REQUIRED)
	public void testDeleteSalarie()
	{
		
		//Given l'objet qu'on va avoir ; exemple : Salarie s1 = new salarie
		
		Salarie salarie = salarieRepository.save(salarie2);
		int id = salarie.getId();
		
		//When
		salarieRepository.delete(salarie);
		salarie = salarieRepository.getReferenceById(id);
//		salarieRepository.deleteById(id);
//		Salarie deletedSalarie = salarieRepository.getReferenceById(id);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {salarieRepository.deleteById(1);});
		
		//Then
		assertThat(salarie).isNull();
	}
	
	@Test
	public void testUpdateSalarie()
	{
		//Given
		Salarie s1 = salarieRepository.save(salarie2); //on le save en BDD
		
		//When
		s1.setNom("Hadock");
		s1.setPrenom("Capitaine");
		Salarie s2 = salarieRepository.save(s1);
		
		//Then
		assertThat(s2).isNotNull();
		assertThat(s2.getNom()).isEqualTo("Hadock");
		assertThat(s2.getPrenom()).isEqualTo("Capitaine");
	}
	
	@Test
	public void testGetAllSalarie()
	{
		// Given
		Salarie s1 = salarieRepository.save(new Salarie("Paul Jones", "John", "jc@gmail.com"));
		Salarie s2 = salarieRepository.save(new Salarie("Plant", "Robert", "jc@gmail.com"));
		
		//When
		List<Salarie> listeSalaries = salarieRepository.findAll();
		
		//Then
		assertThat(listeSalaries).isNotEmpty();
		assertThat(listeSalaries).hasSize(7);
		
	}
	
}