package com.reservafacil.factory;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import com.reservafacil.model.Agendamento;

public class TaxaATest {

	@Test
	public void calculaTaxaTest() {
		Taxa taxa = new TaxaA();
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, "A", LocalDate.now());
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(5).setScale(2), taxaCalculada.setScale(2));
	}

}
