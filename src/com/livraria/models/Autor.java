package com.livraria.models;


public class Autor {
	private int id;
	private String nome;
	private String telefone;
	private String cpf;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String toString() {
		
		return getId() +"  -  "+
				"Nome: " + getNome() +
				"  CPF: "+ getCpf() +
				"  Telefone: " + getTelefone()  ;
	}
	
	
	

}
