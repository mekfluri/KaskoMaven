package KaskoMaven;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "korisnik")
public class Korisnik {

	@Id
	@Column(name = "JMBG")
	private long jmbg;
	
	@Column(name = "Ime")
	private String ime;
	
	@Column(name = "Prezime")
	private String prezime;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "BrojTelefona")
	private String brTelefona;
	
	
	public long getJmbg() {
		return jmbg;
	}

	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrTelefona() {
		return brTelefona;
	}

	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}

	
	public Korisnik() 
	{
		this.setJmbg(-1);
		this.setIme("/");
		this.setPrezime("/");
		this.setEmail("/");
		this.setBrTelefona("/");
	}
	
	
	public Korisnik(int jmbg, String ime, String prezime, String email, String brTelefona) {
		this.setJmbg(jmbg);
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setEmail(email);
		this.setBrTelefona(brTelefona);
	}
	
	
	public String toString() {
		return getJmbg() + " " + getJmbg() + " " + getIme() + " " + getPrezime() + " " + getEmail() + " " + getBrTelefona();
	}
	
}