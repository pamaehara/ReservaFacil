package com.reservafacil.factory;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservafacil.model.Agendamento;

@Service
public class TaxaD extends Taxa {

	@Autowired
	private TaxaA taxaA;
	
	@Autowired
	private TaxaB taxaB;
	
	@Autowired
	private TaxaC taxaC;
	
	public TaxaD(TaxaA taxaA, TaxaB taxaB, TaxaC taxaC) {
		super();
		this.taxaA = taxaA;
		this.taxaB = taxaB;
		this.taxaC = taxaC;
	}

	@Override
	public BigDecimal calculaTaxa(Agendamento agendamento) {
		if(BigDecimal.valueOf(25000).setScale(2).compareTo(agendamento.getValor().setScale(2)) >= 0) {
			return taxaA.calculaTaxa(agendamento);
		} else if(BigDecimal.valueOf(25001).setScale(2).compareTo(agendamento.getValor().setScale(2)) <= 0 &&
				BigDecimal.valueOf(120000).setScale(2).compareTo(agendamento.getValor().setScale(2)) >= 0) {
			return taxaB.calculaTaxa(agendamento);
		} else {
			return taxaC.calculaTaxa(agendamento);
		}
	}

}
