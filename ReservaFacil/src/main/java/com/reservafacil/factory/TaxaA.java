package com.reservafacil.factory;

import java.math.BigDecimal;

import com.reservafacil.model.Agendamento;

public class TaxaA extends Taxa {

	@Override
	public BigDecimal calculaTaxa(Agendamento agendamento) {
		return agendamento.getValor().multiply(BigDecimal.valueOf(0.03)).add(BigDecimal.valueOf(2));
	}

}
