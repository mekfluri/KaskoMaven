package KaskoMaven;
import javax.persistence.EntityManager;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;

@Remote(Korisnik.class)
@Stateless
public class KorisnikServiceImpl implements KorisnikService {

	private EntityManager em;
	
	public KorisnikServiceImpl()
	{
		EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("OsiguranjePU");
		em = emf.createEntityManager();
	}
	
	@Override
	public void registrujNovogKorisnika(int jmbg, String ime, String prezime, String email, String brTelefona) {
		try
		{
			if(pronadjiKorisnika(jmbg) != null)
				return;
			em.getTransaction().begin();
			Korisnik korisnik = new Korisnik(jmbg, ime, prezime, email, brTelefona);
			em.persist(korisnik);
			em.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public boolean obrisiKorisnika(int jmbg) {
		try {
			Korisnik korisnik = pronadjiKorisnika(jmbg);
			if(korisnik != null)
			{
				em.getTransaction().begin();
				em.remove(korisnik);
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
				em.getTransaction().begin();
				o.setPlatio(true);
				em.merge(o);
				em.getTransaction().commit();
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

	
	
}
