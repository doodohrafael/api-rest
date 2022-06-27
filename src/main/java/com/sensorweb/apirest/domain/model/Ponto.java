package com.sensorweb.apirest.domain.model;

import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ponto")
@Data
public class Ponto {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "xid")
	private String xid;
	
	@OneToMany
	@JoinColumn(name = "ponto_id")
	private List<Dado> dados = new Vector<Dado>();
	
	public Ponto() {
	}

	public Ponto(String nome, String xid) {
		this.nome = nome;
		this.xid = xid;
	}

	@Override
	public String toString() {
		return "Ponto [id=" + id + ", nome=" + nome + 
				", xid=" + xid + "]";
	}
}
