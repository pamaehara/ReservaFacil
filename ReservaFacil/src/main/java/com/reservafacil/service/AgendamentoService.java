package com.reservafacil.service;

import java.util.List;

import com.reservafacil.model.Agendamento;

public interface AgendamentoService {

	public List<String> inserirAgendamento(Agendamento agendamento);
	public List<Agendamento> listaAgendamentos();
}
