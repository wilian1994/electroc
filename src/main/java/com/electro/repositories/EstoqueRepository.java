package com.electro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electro.entity.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque,Long>{

	
}
