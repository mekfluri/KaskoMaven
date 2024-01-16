package KaskoMaven;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;



public class Main {

private static EntityManager em;
	
	private static List<Osiguranje> listaOsiguranja;
	private static List<Korisnik> listaKorisnika;
	private static List<Vozilo> listaVozila;
	
 
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("OsiguranjePU");
		em = emf.createEntityManager();
		
		listaKorisnika = procitajSveKorisnike();
		listaOsiguranja = procitajSvaOsiguranja();
		listaVozila = procitajSvaVozila();
		
		KorisnikServiceImpl ksi = new KorisnikServiceImpl();
		
		ksi.registrujNovogKorisnika(666666, "testic", "testic", "testic@gmail.com", "0123123");
		
		ksi.podnesiZahtev(123124);
		
		ksi.obrisiKorisnika(123124);
		
		ksi.platiOsiguranje(123123);
		
		VoziloServiceImpl vsi = new VoziloServiceImpl();
		
		vsi.registrujNovoVozilo(54321, "Punto", 600, 90, 666666);
		
		System.out.println(vsi.pronadjiVozilo(11111));
		
		vsi.obrisiVozilo(11111);
		
		System.out.println(vsi.osiguranoVozilo(20022));
		
		
		
		OsiguranjeServiceImpl osi = new OsiguranjeServiceImpl();
		
		osi.registrujNovoOsiguranje(123124);
		
		osi.obrisiOsiguranje(123124);
		
		System.out.println(osi.pronadjiOsiguranje(123123));
	
		osi.osigurajVozilo(666666, 777777);
	}

	
	
	private static List<Osiguranje> procitajSvaOsiguranja(){
		TypedQuery<Osiguranje> query = em.createQuery("select o from Osiguranje o", Osiguranje.class);
		for(Osiguranje o: query.getResultList()) {
			System.out.println(o);
		}
		return query.getResultList();
	}
	
	private static List<Korisnik> procitajSveKorisnike(){
		TypedQuery<Korisnik> query = em.createQuery("select k from Korisnik k", Korisnik.class);
		for(Korisnik k: query.getResultList()) {
			System.out.println(k);
		}
		return query.getResultList();
	}
	
	private static List<Vozilo> procitajSvaVozila(){
		TypedQuery<Vozilo> query = em.createQuery("select v from Vozilo v", Vozilo.class);
		for(Vozilo v: query.getResultList()) {
			System.out.println(v);
		}
		return query.getResultList();
	}
}
