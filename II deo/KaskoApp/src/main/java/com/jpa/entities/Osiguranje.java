package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "osiguranjevozila")
public class Osiguranje {

	@TableGenerator(name = "osiguranje_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "osiguranje_gen")
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "osiguranje_gen")
	private int id;
	
	@Column(name = "KorisnikPlatio")
	private boolean platio;
	
	@Column(name = "korisnik_JMBG")
	private int korisnikJMBG;
	
	public Osiguranje() {
		this.platio = false;
	}
	
	public Osiguranje(int korisnikJMBG) {
		this.platio = false;
		this.korisnikJMBG = korisnikJMBG;
	}
	
	public int getId() {
		return id;
	}

	public boolean getPlatio() {
		return this.platio;
	}
	
	public void setPlatio(boolean platio) {
		this.platio = platio;
	}
	
	public int getKorisnikJMBG() {
		return korisnikJMBG;
	}
	
	public void setKorisnikJMBG(int jmbg) {
		this.korisnikJMBG = jmbg;
	}
	
	
	public String toString() {
		return getId() + " " + getPlatio() + " " + getKorisnikJMBG();
	}
	
}
