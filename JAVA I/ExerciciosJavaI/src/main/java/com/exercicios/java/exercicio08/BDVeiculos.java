package com.exercicios.java.exercicio08;

import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
	private List<Passeio> listaPasseio = new ArrayList<>();
	private List<Carga> listaCarga = new ArrayList<>();
	
	public List<Passeio> getListaPasseio() {
		return listaPasseio;
	}
	public void setListaPasseio(List<Passeio> listaPasseio) {
		this.listaPasseio = listaPasseio;
	}
	public List<Carga> getListaCarga() {
		return listaCarga;
	}
	public void setListaCarga(List<Carga> listaCarga) {
		this.listaCarga = listaCarga;
	}


	
}
