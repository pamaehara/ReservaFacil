package com.reservafacil.factory;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import com.reservafacil.model.Agendamento;

public class TaxaBTest {

	@Test
	public void calculaTaxaTest() {
		Taxa taxa = new TaxaB();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", LocalDate.now());
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(10).setScale(2), taxaCalculada.setScale(2));
	}

	@Test
	public void calculaTaxaTest1() {
		Taxa taxa = new TaxaB();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", 
				LocalDate.now().plusDays(30));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(10).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest2() {
		Taxa taxa = new TaxaB();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", 
				LocalDate.now().plusDays(40));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(8).setScale(2), taxaCalculada.setScale(2));
	}
	
}
