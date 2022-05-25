package com.inti.SpringBootTD2_10.service;

import java.util.List;

import com.inti.SpringBootTD2_10.model.Salarie;


public interface SalarieService
{
		//Create
		void saveSalarie(Salarie salarie);
		
		//Read all the Salaries
		List<Salarie> getListSalaries();
		
		//Read one Salarie
		Salarie getSalarie(int id);
		
		//Update
		void updateSalarie(Salarie salarie);
		
		//Delete
		void deleteSalarie(int id);
}
