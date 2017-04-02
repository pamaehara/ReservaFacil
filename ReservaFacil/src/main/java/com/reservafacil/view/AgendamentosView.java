package com.reservafacil.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.reservafacil.model.Agendamento;
import com.reservafacil.service.AgendamentoService;

@Component("AgendamentosMB")
@Scope("session")
public class AgendamentosView implements Serializable {

	@Autowired
	private AgendamentoService agendamentoService;

	private List<Agendamento> agendamentos = new ArrayList<Agendamento>();

	@PostConstruct
	public void init() {
		agendamentos = agendamentoService.listaAgendamentos();
	}
	
	public void atualizar() {
		agendamentos = agendamentoService.listaAgendamentos();
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

}