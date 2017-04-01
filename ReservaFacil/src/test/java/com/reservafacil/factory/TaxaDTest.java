package com.reservafacil.factory;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.reservafacil.constante.TipoENUM;
import com.reservafacil.model.Agendamento;

@RunWith(MockitoJUnitRunner.class)
public class TaxaDTest {

	@InjectMocks
    private TaxaD taxa;

    @Mock
    private TaxaA taxaA;
    
    @Mock
    private TaxaB taxaB;
    
    @Mock
    private TaxaC taxaC;
    
    @Before
    public void initMocks() {
    	MockitoAnnotations.initMocks(this);
    }

    
	@Test
	public void calculaTaxaTest() {
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(100), null, null, TipoENUM.D, LocalDate.now());
		Mockito.when(taxaA.calculaTaxa(agendamento)).thenReturn(BigDecimal.valueOf(5));
		
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(5).setScale(2), taxaCalculada.setScale(2));
	}

	@Test
	public void calculaTaxaTest1() {
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(30000), null, null, TipoENUM.D, LocalDate.now());
		Mockito.when(taxaB.calculaTaxa(agendamento)).thenReturn(BigDecimal.valueOf(10));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(10).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest2() {
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(125000), null, null, TipoENUM.D, LocalDate.now());
		Mockito.when(taxaC.calculaTaxa(agendamento)).thenReturn(BigDecimal.valueOf(10375));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(10375).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest3() {
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(25000), null, null, TipoENUM.D, LocalDate.now());
		Mockito.when(taxaA.calculaTaxa(agendamento)).thenReturn(BigDecimal.valueOf(752));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(752).setScale(2), taxaCalculada.setScale(2));
	}
	
	@Test
	public void calculaTaxaTest4() {
		Agendamento agendamento = new Agendamento(1, "12345-0", "54321-0", BigDecimal.valueOf(120000), null, null, TipoENUM.D, LocalDate.now());
		Mockito.when(taxaB.calculaTaxa(agendamento)).thenReturn(BigDecimal.valueOf(10));
		BigDecimal taxaCalculada = taxa.calculaTaxa(agendamento);
		assertEquals(BigDecimal.valueOf(10).setScale(2), taxaCalculada.setScale(2));
	}
	
}
