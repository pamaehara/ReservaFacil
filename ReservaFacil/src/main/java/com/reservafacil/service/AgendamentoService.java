package com.reservafacil.service;

import java.util.List;

import com.reservafacil.model.Agendamento;

public interface AgendamentoService {

	public String inserirAgendamento(Agendamento agendamento);
	public List<Agendamento> listaAgendamentos();
}
