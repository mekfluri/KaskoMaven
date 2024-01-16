package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "vozilo")
public class Vozilo {

	@TableGenerator(name = "vozilo_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "vozilo_gen")
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "vozilo_gen")
	@Column(name = "id")
	private int brSasije;
	
	@Column(name = "ModelVozila")
	private String modelVozila;
	
	@Column(name = "Kubikaza")
	private int kubikaza;
	
	@Column(name = "Jacina")
	private int jacina;
	
	@Column(name = "Korisnik_JMBG")
	private long korisnikJMBG;
	
	@Column(name = "osigurano")
	private boolean voziloOsigurano;
	
	public int getBrSasije() {
		return brSasije;
	}
	
	public void setBrSasije(int brSasije) {
		this.brSasije = brSasije;
	}
	
	public String getModelVozila() {
		return modelVozila;
	}
	
	public void setModelVozila(String modelVozila) {
		this.modelVozila = modelVozila;
	}
	
	public int getKubikaza() {
		return kubikaza;
	}
	
	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}
	
	public int getJacina() {
		return jacina;
	}
	
	public void setJacina(int jacina) {
		this.jacina = jacina;
	}
	
	public long getKorisnikJMBG(){
		return this.korisnikJMBG;
	}
	
	public void setKorisnikJMBG(long korisnikJMBG) {
		this.korisnikJMBG = korisnikJMBG;
	}
	
	public boolean getOsigurano(){
		return this.voziloOsigurano;
	}
	
	public void setOsigurano(boolean osigurano) {
		this.voziloOsigurano = osigurano;
	}
	
	public Vozilo() {
		this.setBrSasije(-1);
		this.setModelVozila("/");
		this.setKubikaza(-1);
		this.setJacina(-1);
		this.setKorisnikJMBG(-1);
		this.setOsigurano(false);
	}
	
	
	public Vozilo(int brSasije, String modelVozila, int kubikaza, int jacina, long korisnikJMBG) {
		this.setBrSasije(brSasije);
		this.setModelVozila(modelVozila);
		this.setKubikaza(kubikaza);
		this.setJacina(jacina);
		this.setKorisnikJMBG(korisnikJMBG);
		this.setOsigurano(false);
	}
	
	
	public String toString() {
		return getBrSasije() + " " + getModelVozila() + " " + getKubikaza() + " " + getJacina();
	}
}
