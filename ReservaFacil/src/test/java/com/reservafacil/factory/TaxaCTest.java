package com.reservafacil.factory;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import com.reservafacil.model.Agendamento;

public class TaxaCTest {

	@Test
	public void calculaTaxaTest() {
		Taxa taxa = new TaxaC();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", LocalDate.now());
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(8.3).setScale(2), taxaCalculada.setScale(2));
	}

	@Test
	public void calculaTaxaTest1() {
		Taxa taxa = new TaxaC();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", 
				LocalDate.now().plusDays(5));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(8.3).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest2() {
		Taxa taxa = new TaxaC();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", 
				LocalDate.now().plusDays(10));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(7.4).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest3() {
		Taxa taxa = new TaxaC();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", 
				LocalDate.now().plusDays(15));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(6.7).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest4() {
		Taxa taxa = new TaxaC();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", 
				LocalDate.now().plusDays(20));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(5.4).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest5() {
		Taxa taxa = new TaxaC();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", 
				LocalDate.now().plusDays(25));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(4.3).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest6() {
		Taxa taxa = new TaxaC();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", 
				LocalDate.now().plusDays(30));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(2.1).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest7() {
		Taxa taxa = new TaxaC();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", 
				LocalDate.now().plusDays(35));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(1.2).setScale(2), taxaCalculada.setScale(2));
	}
	
}
