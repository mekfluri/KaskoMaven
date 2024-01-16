package com.ejb.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.VoziloService;
import com.jpa.entities.Vozilo;


@Stateless
public class VoziloServiceImpl implements VoziloService {
	
	@PersistenceContext(name = "KaskoApp")
	
	private EntityManager em;
	
	@Override
	public Vozilo registrujNovoVozilo(int brSasije, String modelVozila, int kubikaza, int jacina, long korisnikJMBG) {
		try
		{
			if(pronadjiVozilo(brSasije) != null) {
				return null;
			}
			Vozilo vozilo = new Vozilo(brSasije, modelVozila, kubikaza, jacina, korisnikJMBG);
			em.persist(vozilo);
			return vozilo;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public boolean obrisiVozilo(int brSasije) {
		try {
			Vozilo vozilo = pronadjiVozilo(brSasije);
			if(vozilo != null)
			{
				em.remove(vozilo);
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	@Override
	public Vozilo pronadjiVozilo(int brSasije) {
		try
		{
			return em.createQuery("select v from Vozilo v where v.id="+brSasije, Vozilo.class).getSingleResult();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}


	@Override
	public boolean osiguranoVozilo(int brSasije) {
		try
		{
			Vozilo vozilo = pronadjiVozilo(brSasije);
			if(vozilo != null)
				return vozilo.getOsigurano();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return false;
	}
	
	
	@Override
	public List<Vozilo> vratiListuVozila() {
		try
		{
			return em.createQuery("SELECT v FROM Vozilo v", Vozilo.class).getResultList();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return new ArrayList<Vozilo>();
	}
	
}
