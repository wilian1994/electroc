package com.electro.utils;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.electro.entity.Estoque;


@Entity
public class Recebimento {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Estoque estoque;
	private LocalDate dataRecimento;
	private int quantidade;
	
	public Recebimento(Estoque estoque, LocalDate data, int quantidade){
		this.estoque = estoque;
		this.dataRecimento = data;
		this.quantidade = quantidade;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public LocalDate getDataRecimento() {
		return dataRecimento;
	}
	public void setDataRecimento(LocalDate dataRecimento) {
		this.dataRecimento = dataRecimento;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
