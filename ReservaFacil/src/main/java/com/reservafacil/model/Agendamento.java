package com.reservafacil.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Agendamento {

	@Id
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="contaOrigem", nullable=false, unique=false)
	@NotEmpty
	@Size(min=7, max=7)
	private String contaOrigem;

	@Column(name="contaDestino", nullable=false, unique=false)
	@NotEmpty
	@Size(min=7, max=7)
	private String contaDestino;

	@Column(name="valor", nullable=false, unique=false)
	@NotNull
	private BigDecimal valor;
	
	@Column(name="taxa", nullable=false, unique=false)
	private BigDecimal taxa;
	
	@Column(name="dataAgendamento", unique=false)
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dataAgendamento;
	
	@Column(name="tipo", nullable=false, unique=false)
	@NotEmpty
	@Size(min=1, max=1)
	private String tipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="timestamp", unique=false, insertable=false)
	private Date timestamp;
	
	public Agendamento() {
		super();
	}

	public Agendamento(int id, String contaOrigem, String contaDestino, BigDecimal valor, BigDecimal taxa,
			Date timestamp, String tipo, Date dataAgendamento) {
		super();
		this.id = id;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.taxa = taxa;
		this.timestamp = timestamp;
		this.tipo = tipo;
		this.dataAgendamento = dataAgendamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@PrePersist
	protected void onCreate() {
	    if (timestamp == null) { timestamp = new Date(); }
	}

	public Date getDataTransferencia() {
		return timestamp;
	}

	public void setDataTransferencia(Date timestamp) {
		this.timestamp = timestamp;
	}

}