package KaskoMaven;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ejb.Remote;
import javax.ejb.Stateless;


@Remote(Vozilo.class)
@Stateless
public class VoziloServiceImpl implements VoziloService {

private EntityManager em;
	
	public VoziloServiceImpl()
	{
		EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("OsiguranjePU");
		em = emf.createEntityManager();
	}
	
	
	@Override
	public void registrujNovoVozilo(int brSasije, String modelVozila, int kubikaza, int jacina, long korisnikJMBG) {
		try
		{
			if(pronadjiVozilo(brSasije) != null) {
				return;
			}
			em.getTransaction().begin();
			Vozilo vozilo = new Vozilo(brSasije, modelVozila, kubikaza, jacina, korisnikJMBG);
			em.persist(vozilo);
			em.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public boolean obrisiVozilo(int brSasije) {
		try {
			Vozilo vozilo = pronadjiVozilo(brSasije);
			if(vozilo != null)
			{
				em.getTransaction().begin();
				em.remove(vozilo);
				em.getTransaction().commit();
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
	
}
