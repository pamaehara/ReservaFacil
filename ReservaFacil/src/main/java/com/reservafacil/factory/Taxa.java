package com.reservafacil.factory;

import java.math.BigDecimal;

import com.reservafacil.model.Agendamento;

public abstract class Taxa {
	public abstract BigDecimal calculaTaxa(Agendamento agendamento);
}
