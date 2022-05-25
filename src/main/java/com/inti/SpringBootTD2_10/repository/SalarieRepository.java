package com.inti.SpringBootTD2_10.repository;

import com.inti.SpringBootTD2_10.model.Salarie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //pour pouvoir instancier l'injection de dépendance
public interface SalarieRepository extends JpaRepository<Salarie, Integer>
{

}
