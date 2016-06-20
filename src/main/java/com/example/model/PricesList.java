package com.example.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "prices_list")
public class PricesList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	@NotNull
	private Integer idSap;
	
	@NotNull
	private String currency;
	
	@NotNull
	private String base;
	
	private String country;
	private String description;
	private Boolean valid;
	private Date lastUpdated;
	private Date dateCreated;
	
	
	
	
	public PricesList(){}
	
	public PricesList(Integer idSap, String currency, String base) {
		super();
		this.idSap = idSap;
		this.currency = currency;
		this.base = base;
	}
	
	public PricesList(Integer idSap, String currency, String base, String country, String description,
			Boolean valid, Date lastUpdated, Date dateCreated) {
		super();
		
		this.idSap = idSap;
		this.currency = currency;
		this.base = base;
		this.country = country;
		this.description = description;
		this.valid = valid;
		this.lastUpdated = lastUpdated;
		this.dateCreated = dateCreated;
	}
	
	
	
	@Override
	public String toString() {
		return "PricesList [id=" + id + ", idSap=" + idSap + ", currency=" + currency + ", base=" + base + ", country="
				+ country + ", description=" + description + ", valid=" + valid + ", lastUpdated=" + lastUpdated
				+ ", dateCreated=" + dateCreated + "]";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getIdSap() {
		return idSap;
	}
	public void setIdSap(Integer idSap) {
		this.idSap = idSap;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
