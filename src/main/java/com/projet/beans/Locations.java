package com.projet.beans;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name = "locations")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idLocation")
public class Locations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLocation", nullable=false)
	int idLocation;

	@Column(name="dDebutLocation")
	@Temporal(TemporalType.DATE)
	Date dDebutLocation;

	@Column(name="dFinLocation")
	@Temporal(TemporalType.DATE)
	Date dFinLocation;

	@Column(name="dateLocation")
	@Temporal(TemporalType.DATE)
	Date dateLocation;
	
	@Column(name="priceTotal")
	float priceTotal;
	

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idUtilisateur",nullable = false)
	private Utilisateurs user;


	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(
			name = "livreLouer", 
			joinColumns = { @JoinColumn(name = "idLocation") }, 
			inverseJoinColumns = { @JoinColumn(name = "idLivre") }
			)
	private Set<Livres> livre = new HashSet<>();

	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(
			name = "userLoc", 
			joinColumns = { @JoinColumn(name = "idLocation") }, 
			inverseJoinColumns = { @JoinColumn(name = "idLivre") }
			)
	private List<Livres> book = new ArrayList<>();
	


	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public Date getdDebutLocation() {
		return dDebutLocation;
	}

	public void setdDebutLocation(Date dDebutLocation) {
		this.dDebutLocation = dDebutLocation;
	}

	public Date getdFinLocation() {
		return dFinLocation;
	}

	public void setdFinLocation(Date dFinLocation) {
		this.dFinLocation = dFinLocation;
	}

	public Date getDateLocation() {
		return dateLocation;
	}

	public void setDateLocation(Date dateLocation) {
		this.dateLocation = dateLocation;
	}

	@JsonIgnore
	public Utilisateurs getUser() {
		return user;
	}

	
	public List<Livres> getBook() {
		return book;
	}

	public void setBook(List<Livres> book) {
		this.book = book;
	}

	public void setUser(Utilisateurs user) {
		this.user = user;
	}
	
	public Set<Livres> getLivre() {
		return livre;
	}

	public void setLivre(Set<Livres> livre) {
		this.livre = livre;
	}

	public float getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(float priceTotal) {
		this.priceTotal = priceTotal;
	}
	
	

	
	
}
