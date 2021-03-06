package com.reservafacil.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservafacil.dao.AgendamentoDAO;
import com.reservafacil.factory.CriaTaxa;
import com.reservafacil.model.Agendamento;

@Service
@Transactional
public class AgendamentoServiceImpl implements AgendamentoService {

	@Autowired
	private AgendamentoDAO agendamentoDAO;
	
	@Autowired
	private CriaTaxa criaTaxa;

	@Override
	public List<String> inserirAgendamento(Agendamento agendamento) {
		List<String> msgs = new ArrayList<String>();
		try {
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<Agendamento>> constraintViolations = validator.validate(agendamento);

			if(constraintViolations != null && constraintViolations.size() > 0) {
				constraintViolations.forEach(erro -> msgs.add(erro.getPropertyPath() + " " + erro.getMessage()));
				return msgs;
			}

			agendamento.setTaxa(criaTaxa.criaTaxa(agendamento.getTipo()).calculaTaxa(agendamento));
			agendamentoDAO.inserirAgendamento(agendamento);
			msgs.add("Agendamento cadastro com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			msgs.add("Falha ao tentar agendar transferencia. Favor entrar em contato com a equipe tecnica.");
		}
		return msgs;
	}

	@Override
	public List<Agendamento> listaAgendamentos() {
		return agendamentoDAO.listaAgendamentos();
	}

}
