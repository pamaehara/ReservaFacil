package com.reservafacil.factory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.reservafacil.model.Agendamento;

@Service
public class TaxaC extends Taxa {

	@Override
	public BigDecimal calculaTaxa(Agendamento agendamento) {
		long diferencaEmDias = ChronoUnit.DAYS.between(LocalDate.now(), agendamento.getDataAgendamento());
		BigDecimal taxa = BigDecimal.ZERO;
		if(diferencaEmDias <= 5) {
			taxa = BigDecimal.valueOf(0.083);
		} else if(diferencaEmDias <= 10) {
			taxa = BigDecimal.valueOf(0.074);
		} else if(diferencaEmDias <= 15) {
			taxa = BigDecimal.valueOf(0.067);
		} else if(diferencaEmDias <= 20) {
			taxa = BigDecimal.valueOf(0.054);
		} else if(diferencaEmDias <= 25) {
			taxa = BigDecimal.valueOf(0.043);
		} else if(diferencaEmDias <= 30) {
			taxa = BigDecimal.valueOf(0.021);
		} else if(diferencaEmDias > 30) {
			taxa = BigDecimal.valueOf(0.012);
		}
		return agendamento.getValor().multiply(taxa);
	}

}
