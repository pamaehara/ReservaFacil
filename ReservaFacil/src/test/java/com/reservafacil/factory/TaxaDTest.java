package com.reservafacil.factory;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import com.reservafacil.model.Agendamento;

public class TaxaDTest {

	@Test
	public void calculaTaxaTest() {
		Taxa taxa = new TaxaD();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", LocalDate.now());
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(5).setScale(2), taxaCalculada.setScale(2));
	}

	@Test
	public void calculaTaxaTest1() {
		Taxa taxa = new TaxaD();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(30000), null, null, "A", LocalDate.now());
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(10).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest2() {
		Taxa taxa = new TaxaD();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(125000), null, null, "A", LocalDate.now());
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(10375).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest3() {
		Taxa taxa = new TaxaD();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(25000), null, null, "A", LocalDate.now());
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(752).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest4() {
		Taxa taxa = new TaxaD();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(120000), null, null, "A", LocalDate.now());
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(10).setScale(2), taxaCalculada.setScale(2));
	}
	
}
