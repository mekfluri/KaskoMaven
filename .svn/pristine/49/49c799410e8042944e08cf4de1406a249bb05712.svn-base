package com.ejb.services;

import java.util.List;

import com.jpa.entities.Korisnik;

import java.io.IOException;






public interface KorisnikService {
	public Korisnik registrujNovogKorisnika(int jmbg, String ime, String prezime, String email, String brTelefona);
	public boolean obrisiKorisnika(int jmbg);
	public void podnesiZahtev(int jmbg);
	public void platiOsiguranje(int jmbg);
	public Korisnik pronadjiKorisnika(int jmbg);
	public void dodajVozilo(int brSasije, String modelVozila, int kubikaza, int jacina, int korisnikJMBG);
	public List<Korisnik> vratiListuKorisnika() ;
	public void sendGet(int jmbg) throws IOException;
}
