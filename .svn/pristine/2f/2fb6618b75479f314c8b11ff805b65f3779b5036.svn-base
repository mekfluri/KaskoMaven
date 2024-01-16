package com.ejb.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.OsiguranjeService;
import com.jpa.entities.Korisnik;
import com.jpa.entities.Osiguranje;
import com.jpa.entities.Vozilo;




@Stateless
public class OsiguranjeServiceImpl implements OsiguranjeService {

	@PersistenceContext(name = "KaskoApp")
	private EntityManager em;
	
	
	@Override
	public Osiguranje registrujNovoOsiguranje(int korisnikJMBG) {
		try
		{
			if(pronadjiOsiguranje(korisnikJMBG) != null)
				return null;
			Osiguranje osiguranje = new Osiguranje(korisnikJMBG);
			em.persist(osiguranje);
			return osiguranje;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public boolean obrisiOsiguranje(int korisnikJMBG) {
		try {
			Osiguranje osiguranje = pronadjiOsiguranje(korisnikJMBG);
			if(osiguranje != null)
			{
				em.remove(osiguranje);
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
	public Osiguranje pronadjiOsiguranje(int korisnikJMBG) {
		try
		{
			return em.createQuery("SELECT o FROM Osiguranje o WHERE o.korisnikJMBG=" + korisnikJMBG, Osiguranje.class).getSingleResult();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public boolean osigurajVozilo(int korisnikJMBG, int brSasije) {
		KorisnikServiceImpl ksi = new KorisnikServiceImpl();
		Korisnik k = ksi.pronadjiKorisnika(korisnikJMBG);
		VoziloServiceImpl vsi = new VoziloServiceImpl();
		Vozilo v = vsi.pronadjiVozilo(brSasije);
		
		if(k == null || v == null)
			return false;
		
		try
		{
			ksi.podnesiZahtev(korisnikJMBG);
			ksi.platiOsiguranje(korisnikJMBG);
			v.setOsigurano(true);
			em.merge(v);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return true;
	}
	
	@Override
	public List<Osiguranje> vratiListuOsiguranja() {
		try
		{
			return em.createQuery("SELECT o FROM Osiguranje o", Osiguranje.class).getResultList();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return new ArrayList<Osiguranje>();
	}
}
