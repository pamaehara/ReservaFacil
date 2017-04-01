package com.reservafacil.dao;

import java.util.List;

import com.reservafacil.model.Agendamento;

public interface AgendamentoDAO {

	public void inserirAgendamento(Agendamento agendamento);

	public List<Agendamento> listaAgendamentos();

}