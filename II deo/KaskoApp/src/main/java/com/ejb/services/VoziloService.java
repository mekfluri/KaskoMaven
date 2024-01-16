package com.ejb.services;

import java.util.List;

import com.jpa.entities.Vozilo;





public interface VoziloService {
	public Vozilo registrujNovoVozilo(int brSasije, String modelVozila, int kubikaza, int jacina, long korisnikJMBG);
	public boolean obrisiVozilo(int brSasije);
	public Vozilo pronadjiVozilo(int brSasije);
	public boolean osiguranoVozilo(int brSasije);
	public List<Vozilo> vratiListuVozila() ;
}
