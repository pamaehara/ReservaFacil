package com.reservafacil.factory;

import java.math.BigDecimal;

import com.reservafacil.model.Agendamento;

public class TaxaD extends Taxa {

	@Override
	public BigDecimal calculaTaxa(Agendamento agendamento) {
		if(BigDecimal.valueOf(25000).setScale(2).compareTo(agendamento.getValor().setScale(2)) >= 0) {
			return new TaxaA().calculaTaxa(agendamento);
		} else if(BigDecimal.valueOf(25001).setScale(2).compareTo(agendamento.getValor().setScale(2)) <= 0 &&
				BigDecimal.valueOf(120000).setScale(2).compareTo(agendamento.getValor().setScale(2)) >= 0) {
			return new TaxaB().calculaTaxa(agendamento);
		} else {
			return new TaxaC().calculaTaxa(agendamento);
		}
	}

}
