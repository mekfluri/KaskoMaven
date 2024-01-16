
package KaskoMaven;
import static org.junit.Assert.*;

import org.junit.*;




public class KorisnikServiceTest {

private static KorisnikService service;
	
	@BeforeClass
	public static void inicijalizacija() {
		service = new KorisnikServiceImpl();
		assertNotNull(service);
		System.out.println("KorisnikService(Inicijalizacija): Inicijalizacija uspesna!");
	}
	
	
	@Before
	public void preduslovi() {
		Korisnik obj = service.pronadjiKorisnika(184788);
		assertNull(obj);
		System.out.println("KorisnikService(Preduslov): Ne postoji korisnik sa JMBG-om: 184788");
	}
	
	@Test
	public void test() {
		service.registrujNovogKorisnika(184788, "Mitar", "Mitrovic", "mitar@gmail.com", "063184788");
		System.out.println("KorisnikService(Test):  Prijavljivanje korisnika sa JMBG-om 184788");
		
		service.podnesiZahtev(184788);
		System.out.println("KorisnikService(Test): Korisnik sa JMBG-om: 184788 uspesno podneo zahtev za kreiranje osiguranja");
	}
	
	@After
	public void nakonTesta() {
		Korisnik obj = service.pronadjiKorisnika(184788);
		assertNotNull(obj);
		System.out.println("KorisnikService(Nakon testa): Korisnik sa JMBG-om 184788 uspesno ubacen!");
		
		OsiguranjeServiceImpl osi = new OsiguranjeServiceImpl();
		osi.obrisiOsiguranje(184788);
		System.out.println("KorisnikService(Nakon testa): Uspesno obrisano osiguranje korisnika sa JMBG-om: 184788!");
	}
	
	@AfterClass
	public static void okoncavanje() {
		
		assertTrue(service.obrisiKorisnika(184788));
		System.out.println("KorisnikService(Okoncavanje): Korisnik obrisan!");
	}
	
}
