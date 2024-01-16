package com.ejb.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.KorisnikService;
import com.jpa.entities.Korisnik;
import com.jpa.entities.Osiguranje;



@Stateless
public class KorisnikServiceImpl implements KorisnikService {

	@PersistenceContext(name = "KaskoApp")
	private EntityManager em;
	
	
	@Override
	public Korisnik registrujNovogKorisnika(int jmbg, String ime, String prezime, String email, String brTelefona) {
		// TODO Auto-generated method stub
		
		System.out.println("STIGOOO");
			if(pronadjiKorisnika(jmbg) != null)
				return null;
			Korisnik korisnik = new Korisnik(jmbg, ime, prezime, email, brTelefona);
			em.persist(korisnik);

			return korisnik;
			
		
//		catch(Exception ex)
//		{
//			System.out.println(ex.getMessage());
//		}
//		return null;
	}

	public boolean obrisiKorisnika(int jmbg) {
		try {
			Korisnik korisnik = pronadjiKorisnika(jmbg);
			if(korisnik != null)
			{
				em.remove(korisnik);
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
	public void podnesiZahtev(int jmbg) {
		try
		{
			Korisnik korisnik = pronadjiKorisnika(jmbg);
			if(korisnik != null)
			{
				OsiguranjeServiceImpl osi = new OsiguranjeServiceImpl();
				osi.registrujNovoOsiguranje(jmbg);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void platiOsiguranje(int jmbg) {
		try
		{
			Korisnik korisnik = pronadjiKorisnika(jmbg);
			if(korisnik != null)
			{
				Osiguranje o = em.createQuery("SELECT o FROM Osiguranje o WHERE o.korisnikJMBG="+korisnik.getJmbg(), Osiguranje.class).getSingleResult();
				o.setPlatio(true);
				em.merge(o);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public Korisnik pronadjiKorisnika(int jmbg) {
		try
		{
			return em.createQuery("select k from Korisnik k WHERE k.jmbg=" + jmbg, Korisnik.class).getSingleResult();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public void dodajVozilo(int brSasije, String modelVozila, int kubikaza, int jacina, int korisnikJMBG) {
		VoziloServiceImpl vsi = new VoziloServiceImpl();
		if(vsi.pronadjiVozilo(brSasije) != null)
			return;
		vsi.registrujNovoVozilo(brSasije, modelVozila, kubikaza, jacina, korisnikJMBG);
	}
	private static final String USER_AGENT = "Mozilla/5.0";
	public void sendGet(int id) throws IOException {
		System.out.println("pokrenut sendGEt");
		Korisnik s = em.find(Korisnik.class, id);
		URL obj = new URL("http://192.168.99.100/?jmbg_korisnika="+s.getJmbg());
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}
		
	}
	@Override
	public List<Korisnik> vratiListuKorisnika() {
		
			List<Korisnik> lista=em.createQuery("SELECT v FROM Korisnik v", Korisnik.class).getResultList();
			return lista;
		
//		catch(Exception ex)
//		{
//			System.out.println(ex.getMessage());
//		}
//	 return null;
	}
	
	
	
}
