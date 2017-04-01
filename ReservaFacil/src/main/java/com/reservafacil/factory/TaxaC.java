package com.reservafacil.factory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.reservafacil.model.Agendamento;

public class TaxaC extends Taxa {

	@Override
	public BigDecimal calculaTaxa(Agendamento agendamento) {
		long diferencaEmDias = ChronoUnit.DAYS.between(LocalDate.now(), agendamento.getDataAgendamento());
		if(diferencaEmDias <= 5) {
			return agendamento.getValor().multiply(BigDecimal.valueOf(0.083));
		} else if(diferencaEmDias <= 10) {
			return agendamento.getValor().multiply(BigDecimal.valueOf(0.074));
		} else if(diferencaEmDias <= 15) {
			return agendamento.getValor().multiply(BigDecimal.valueOf(0.067));
		} else if(diferencaEmDias <= 20) {
			return agendamento.getValor().multiply(BigDecimal.valueOf(0.054));
		} else if(diferencaEmDias <= 25) {
			return agendamento.getValor().multiply(BigDecimal.valueOf(0.043));
		} else if(diferencaEmDias <= 30) {
			return agendamento.getValor().multiply(BigDecimal.valueOf(0.021));
		} else if(diferencaEmDias > 30) {
			return agendamento.getValor().multiply(BigDecimal.valueOf(0.012));
		}
		return BigDecimal.ZERO;
	}

}
