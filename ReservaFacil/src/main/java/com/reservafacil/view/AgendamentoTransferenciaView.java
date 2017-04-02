package com.reservafacil.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.reservafacil.model.Agendamento;
import com.reservafacil.service.AgendamentoService;

@Component("AgendamentoTransferenciaMB")
@Scope("session")
public class AgendamentoTransferenciaView implements Serializable {

	@Autowired
	private AgendamentoService agendamentoService;

	private Agendamento agendamento = new Agendamento();

	private List<Agendamento> agendamentos = new ArrayList<Agendamento>();

	public String agendar() {
		List<String> msgs = agendamentoService.inserirAgendamento(agendamento);
		msgs.forEach(msg -> 
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null)));
		agendamento = new Agendamento();
		return "/agendamentoTransferencia";
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

}