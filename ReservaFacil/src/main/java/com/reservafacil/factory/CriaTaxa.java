package com.reservafacil.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservafacil.constante.TipoENUM;

@Service
public class CriaTaxa {

	@Autowired
	private TaxaA taxaA;
	@Autowired
	private TaxaA taxaB;
	@Autowired
	private TaxaA taxaC;
	@Autowired
	private TaxaA taxaD;

	public Taxa criaTaxa(TipoENUM tipo) {
		switch(tipo) {
		case A:
			return taxaA;
		case B:
			return taxaB;
		case C:
			return taxaC;
		case D:
			return taxaD;
		default:
			break;
		}
		return null;
	}

}
