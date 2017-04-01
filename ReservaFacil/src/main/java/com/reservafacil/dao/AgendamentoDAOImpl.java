package com.reservafacil.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reservafacil.model.Agendamento;

@Repository
@Transactional
public class AgendamentoDAOImpl implements AgendamentoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void inserirAgendamento(Agendamento agendamento) {
		sessionFactory.getCurrentSession().save(agendamento);
	}

	@Override
	public List<Agendamento> listaAgendamentos() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Agendamento.class);
		return criteria.list();
	}

}
