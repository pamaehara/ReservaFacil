package com.reservafacil.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservafacil.model.Agendamento;
import com.reservafacil.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoRest {

	@Autowired
	private AgendamentoService agendamentoService;
	
	@RequestMapping(value = "/listaAgendamentos", method = RequestMethod.GET)
	public ResponseEntity<List<Agendamento>> listaAgendamentos() {
		List<Agendamento> agendamentos = agendamentoService.listaAgendamentos();
		if(agendamentos.isEmpty()){
            return new ResponseEntity<List<Agendamento>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Agendamento>>(agendamentos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/agendar", method = RequestMethod.POST)
	public ResponseEntity<List<String>> agendar(@RequestBody Agendamento agendamento) {
		List<String> msgs = agendamentoService.inserirAgendamento(agendamento);
		return new ResponseEntity<List<String>>(msgs, HttpStatus.OK);
	}
	
}
