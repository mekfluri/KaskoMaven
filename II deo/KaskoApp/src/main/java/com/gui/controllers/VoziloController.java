package com.gui.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ejb.services.VoziloService;
import com.jpa.entities.Vozilo;



@ManagedBean
@ViewScoped
public class VoziloController {

	private int brSasije;
	private String modelVozila;
	private int kubikaza;
	private int jacina;
	private long korisnikJMBG;
	
	private Vozilo vozilo;
	
	@EJB
	private VoziloService voziloService;
	
	public VoziloController() {
		
	}
	
	public int getBrSasije() {
		return brSasije;
	}
	
	public void setBrSasije(int brSasije) {
		this.brSasije = brSasije;
	}
	
	public String getModelVozila() {
		return modelVozila;
	}
	
	public void setModelVozila(String modelVozila) {
		this.modelVozila = modelVozila;
	}
	
	public int getKubikaza() {
		return kubikaza;
	}
	
	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}
	
	public int getJacina() {
		return jacina;
	}
	
	public void setJacina(int jacina) {
		this.jacina = jacina;
	}
	
	public long getKorisnikJMBG(){
		return this.korisnikJMBG;
	}
	
	public void setKorisnikJMBG(long korisnikJMBG) {
		this.korisnikJMBG = korisnikJMBG;
	}
	
	public Vozilo getVozilo() {
		return this.vozilo;
	}
	
	public void setVozilo(Vozilo v) {
		this.vozilo = v;
	}
	
	public void registrujVozilo(int brSasije, String modelVozila, int kubikaza, int jacina, long korisnikJMBG) {
		try {
			vozilo = voziloService.registrujNovoVozilo(brSasije, modelVozila, kubikaza, jacina, korisnikJMBG);
			if(vozilo == null) {
				System.out.println("Vozilo je vec registrovano u sistem");
			}
			else {
				System.out.println("Uspesno ubacivanje vozila");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void obrisiVozilo(int brSasije) {
		try {
			if(voziloService.obrisiVozilo(brSasije)) {
				System.out.println("Vozilo uspesno obrisano");
			}
			else {
				System.out.println("Vozilo ne postoji u sistemu");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Vozilo> vratiSvaVozila(){
		return voziloService.vratiListuVozila();
	}
}
