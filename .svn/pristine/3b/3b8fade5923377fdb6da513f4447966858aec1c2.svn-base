package com.gui.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ejb.services.OsiguranjeService;
import com.jpa.entities.Osiguranje;



@ManagedBean
@ViewScoped
public class OsiguranjeController {

	private int jmbg;
	private int sasija;
	
	private Osiguranje osiguranje;
	
	@EJB
	private OsiguranjeService osiguranjeService;
	
	public OsiguranjeController() {
		
	}

	
	public int getKorisnikJmbg() {
		return jmbg;
	}

	public void setKorisnikJmbg(int jmbg) {
		this.jmbg = jmbg;
	}
	
	public int getSasija() {
		return sasija;
	}

	public void setSasija(int sasija) {
		this.sasija = sasija;
	}
	
	public Osiguranje getOsiguranje() {
		return this.osiguranje;
	}
	
	public void setOsiguranje(Osiguranje o) {
		this.osiguranje = o;
	}
	
	
	public void registrujOsiguranje(int korisnikJMBG) {
		try {
			osiguranje = osiguranjeService.registrujNovoOsiguranje(jmbg);
			if(osiguranje == null) {
				System.out.println("Osiguranje je vec u sistemu");
			}
			else {
				System.out.println("Uspesno ubacivanje osiguranja u sistem");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void obrisiOsiguranje(int korisnikJMBG) {
		try {
			if(osiguranjeService.obrisiOsiguranje(korisnikJMBG)) {
				System.out.println("Osiguranje uspesno obrisano");
			}
			else {
				System.out.println("Osiguranje ne postoji u sistemu");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void osigurajVozilo(int korisnikJMBG, int brSasije) {
		try {
			if(osiguranjeService.osigurajVozilo(korisnikJMBG, brSasije)) {
				System.out.println("Vozilo korisnika sa JMBG-om " + korisnikJMBG + " uspesno osigurano");
			}
			else {
				System.out.println("Doslo je do greske prilikom osiguranja vozila");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Osiguranje> vrateSvaOsiguranja(){
		return osiguranjeService.vratiListuOsiguranja();
	}
	
	
}
