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
import com.reservafacil.model.Agendamento;

@Service
@Transactional
public class AgendamentoServiceImpl implements AgendamentoService {

	@Autowired
	private AgendamentoDAO agendamentoDAO;
	
	@Override
	public List<String> inserirAgendamento(Agendamento agendamento) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Agendamento>> constraintViolations = validator.validate(agendamento);

		if(constraintViolations != null && constraintViolations.size() > 0) {
			List<String> erros = new ArrayList<String>();
			constraintViolations.forEach(erro -> erros.add(erro.getMessage()));
			return erros;
		}
		
		agendamentoDAO.inserirAgendamento(agendamento);
		
		return null;
	}

	@Override
	public List<Agendamento> listaAgendamentos() {
		return agendamentoDAO.listaAgendamentos();
	}

}
