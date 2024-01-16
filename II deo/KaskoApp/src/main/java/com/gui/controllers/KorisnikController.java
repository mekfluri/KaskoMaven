package com.gui.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.ejb.services.KorisnikService;
import com.jpa.entities.Korisnik;







@ManagedBean
@ViewScoped
public class KorisnikController {
	
	private int jmbg;
	private String ime;
	private String prezime;
	private String email;
	private String brTelefona;
	
	private Korisnik korisnik;
	
	@EJB
	private KorisnikService korisnikService;
	
//	public KorisnikController(){
//		
//	}
	
	public int getJmbg() {
		return jmbg;
	}

	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrTelefona() {
		return brTelefona;
	}

	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}
	
	public Korisnik getKorisnik() {
		return korisnik;
	}
	
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	
	public KorisnikService getKorisnikService() {
		return korisnikService;
	}
	
	public void setKorisnikService(KorisnikService korisnikService) {
		this.korisnikService = korisnikService;
	}
	
	
	public void registrujKorisnika(int jmbg, String ime, String prezime, String email, String brTelefona) {
		try {
			
			korisnik = korisnikService.registrujNovogKorisnika(jmbg, ime, prezime, email, brTelefona);
			if(korisnik == null) {
				System.out.println("Korisnik je vec prijavljen");
			}
			else {
				System.out.println("Uspesno ubacivanje korisnika");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void obrisiKorisnika(int jmbg) {
		System.out.println("Mjau");
		try {
			if(korisnikService.obrisiKorisnika(jmbg)) {
				System.out.println("Korisnik uspesno obrisan");
			}
			else {
				System.out.println("Korisnik ne postoji u sistemu");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	public void sendGet(int jmbg)
    {
    	try {
    		korisnikService.sendGet(jmbg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	public void podnesiZahtev(int jmbg) {
		try {
			if(korisnikService.pronadjiKorisnika(jmbg) != null) {
				korisnikService.podnesiZahtev(jmbg);
				System.out.println("Uspesno podnesen zahtev za osiguranje");
			}
			else {
				System.out.println("Korisnik ne postoji u sistemu");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Korisnik> vratiSveKorisnike(){
		return korisnikService.vratiListuKorisnika();
	}
	
	
}
