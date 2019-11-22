package javafxmvc.model.domain;

import java.io.Serializable;

public class Servico implements Serializable {
	
	private String nome;
	private String id;
	
	
	public Servico() {
		
	}


	public Servico(String nome, String id) {
		super();
		this.nome = nome;
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	

}
