package com.electro.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Nota {
	
	@Id
	@GeneratedValue
	private Long id;
	private int numNota;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataRecebimento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumNota() {
		return numNota;
	}
	public void setNumNota(int numNota) {
		this.numNota = numNota;
	}
	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}
	public void setDataRecebimento(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
	
	

}
