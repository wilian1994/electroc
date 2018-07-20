package com.electro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electro.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota,Long>{
	
}
