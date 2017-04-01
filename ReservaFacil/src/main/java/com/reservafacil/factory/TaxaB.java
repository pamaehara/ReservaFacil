package com.reservafacil.factory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.reservafacil.model.Agendamento;

public class TaxaB extends Taxa {

	@Override
	public BigDecimal calculaTaxa(Agendamento agendamento) {
		long diferencaEmDias = ChronoUnit.DAYS.between(LocalDate.now(), agendamento.getDataAgendamento());
		if(diferencaEmDias <= 30) {
			return BigDecimal.valueOf(10);
		} else {
			return BigDecimal.valueOf(8);
		}
	}

}
