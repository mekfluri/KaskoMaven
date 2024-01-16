package KaskoMaven;

import static org.junit.Assert.*;

import org.junit.*;





public class OsiguranjeServiceTest {

	
private static OsiguranjeService service;
	
	@BeforeClass
	public static void inicijalizacija() {
		service = new OsiguranjeServiceImpl();
		assertNotNull(service);
		System.out.println("OsiguranjeService(Inicijalizacija): Inicijalizacija uspesna!");
	}
	
	
	@Before
	public void preduslovi() {
		Osiguranje obj = service.pronadjiOsiguranje(184788);
		assertNull(obj);
		System.out.println("OsiguranjeService(Preduslov): Ne postoji osiguranje sa korisnickim JMBG-om: 184788");
	}
	
	@Test
	public void test() {
		KorisnikServiceImpl ksi = new KorisnikServiceImpl();
		ksi.registrujNovogKorisnika(184788, "Mitar", "Mitrovic", "mitar@gmail.com", "063184788");
		VoziloServiceImpl vsi = new VoziloServiceImpl();
		vsi.registrujNovoVozilo(810001, "Fica", 300, 50, 184788);
		service.registrujNovoOsiguranje(184788);
		System.out.println("OsiguranjeService(Test): Prijavljivanje osiguranja za korisnika sa JMBG-om: 184788 u sistem USPESNO");
		service.osigurajVozilo(184788, 810001);
	}
	
	@After
	public void nakonTesta() {
		Osiguranje obj = service.pronadjiOsiguranje(184788);
		assertNotNull(obj);
		System.out.println("OsiguranjeService(Nakon testa): Osiguranje za korisnika sa JMBG-om: 184788 uspesno ubacen!");
		
		assertFalse(service.pronadjiOsiguranje(184788).getPlatio());
		VoziloServiceImpl vsi = new VoziloServiceImpl();
		assertTrue(vsi.pronadjiVozilo(810001).getOsigurano());
		System.out.println("OsiguranjeService(Nakon testa): Uspesno registrovanje vozila: 810001 korisniku sa JMBG-om 184788");
	}
	
	@AfterClass
	public static void okoncavanje() {
		assertTrue(service.obrisiOsiguranje(184788));
		System.out.println("OsiguranjeService(Okoncavanje): Osiguranje uspesno obrisano!");
		VoziloServiceImpl vsi = new VoziloServiceImpl();
		assertTrue(vsi.obrisiVozilo(810001));
		KorisnikServiceImpl ksi = new KorisnikServiceImpl();
		assertTrue(ksi.obrisiKorisnika(184788));
	}
	
	
}
