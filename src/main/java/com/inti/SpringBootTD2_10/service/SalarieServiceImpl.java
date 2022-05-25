package com.inti.SpringBootTD2_10.service;

import java.util.List;

import com.inti.SpringBootTD2_10.model.Salarie;
import com.inti.SpringBootTD2_10.repository.SalarieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalarieServiceImpl implements SalarieService
{
	@Autowired
	SalarieRepository salarieRepository;

	@Override
	public void saveSalarie(Salarie salarie)
	{
		salarieRepository.save(salarie);
	}

	@Override
	public List<Salarie> getListSalaries()
	{
		return salarieRepository.findAll();
	}

	@Override
	public Salarie getSalarie(int id)
	{
		return salarieRepository.getReferenceById(id);
	}

	@Override
	public void updateSalarie(Salarie salarie)
	{
		salarieRepository.save(salarie);
	}

	@Override
	public void deleteSalarie(int id)
	{
		salarieRepository.deleteById(id);
	}
}
