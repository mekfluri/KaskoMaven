package KaskoMaven;

import static org.junit.Assert.*;

import org.junit.*;




public class VoziloServiceTest {

	private static VoziloService service;
	
	@BeforeClass
	public static void inicijalizacija() {
		service = new VoziloServiceImpl();
		assertNotNull(service);
		System.out.println("VoziloService(Inicijalizacija): Inicijalizacija uspesna!");
	}
	
	
	@Before
	public void preduslovi() {
		Vozilo obj = service.pronadjiVozilo(810001);
		assertNull(obj);
		System.out.println("VoziloService(Preduslov): Ne postoji vozilo sa brojem sasije: 810001");
	}
	
	@Test
	public void test() {
		service.registrujNovoVozilo(810001, "ladaniva", 500, 60, 666666);
		System.out.println("VoziloService(Test): Ubacivanje vozila sa brojem sasije 810001 u sistem");
	}
	
	@After
	public void nakonTesta() {
		Vozilo obj = service.pronadjiVozilo(810001);
		assertNotNull(obj);
		System.out.println("VoziloService(Nakon testa): Vozilo sa brojem sasije uspesno ubacen!");
	}
	
	@AfterClass
	public static void okoncavanje() {
		
		assertTrue(service.obrisiVozilo(810001));
		System.out.println("VoziloService(Okoncavanje): Vozilo obrisano!");
	}
	
	
}
