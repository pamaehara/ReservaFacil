package com.reservafacil.factory;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reservafacil.constante.TipoENUM;
import com.reservafacil.model.Agendamento;

public class ConverterObjectToJson {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Agendamento obj = new Agendamento(0, "12345-0", "54321-0", BigDecimal.TEN, null, null, TipoENUM.A, LocalDate.now());

		//Object to JSON in String
		String jsonInString = mapper.writeValueAsString(obj);
		System.out.println(jsonInString);
	}

}
