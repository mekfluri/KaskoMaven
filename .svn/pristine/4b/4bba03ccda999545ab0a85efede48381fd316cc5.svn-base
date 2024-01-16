package KaskoMaven;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ejb.Remote;
import javax.ejb.Stateless;


@Remote(Osiguranje.class)
@Stateless
public class OsiguranjeServiceImpl implements OsiguranjeService {

	
	private EntityManager em;
	
	public OsiguranjeServiceImpl()
	{
		EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("OsiguranjePU");
		em = emf.createEntityManager();
	}
	
	@Override
	public void registrujNovoOsiguranje(int korisnikJMBG) {
		try
		{
			if(pronadjiOsiguranje(korisnikJMBG) != null)
				return;
			em.getTransaction().begin();
			Osiguranje osiguranje = new Osiguranje(korisnikJMBG);
			em.persist(osiguranje);
			em.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public boolean obrisiOsiguranje(int korisnikJMBG) {
		try {
			Osiguranje osiguranje = pronadjiOsiguranje(korisnikJMBG);
			if(osiguranje != null)
			{
				em.getTransaction().begin();
				em.remove(osiguranje);
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
	public void osigurajVozilo(int korisnikJMBG, int brSasije) {
		KorisnikServiceImpl ksi = new KorisnikServiceImpl();
		Korisnik k = ksi.pronadjiKorisnika(korisnikJMBG);
		VoziloServiceImpl vsi = new VoziloServiceImpl();
		Vozilo v = vsi.pronadjiVozilo(brSasije);
		
		if(k == null || v == null)
			return;
		
		try
		{
			ksi.podnesiZahtev(korisnikJMBG);
			ksi.platiOsiguranje(korisnikJMBG);
			em.getTransaction().begin();
			v.setOsigurano(true);
			em.merge(v);
			em.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
