package com.task.creditcard.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.task.creditcard.utility.CreditcardNumberValidator;

@Entity
public class CreditCard implements Serializable {

	private static final long serialVersionUID = -6969711731354786002L;

	@Id
	@GeneratedValue
	@Column(updatable = false, nullable = false)
	private Long id;
	@NotNull
	@Column
	private String name;
	@NotNull
	@Column
	@CreditcardNumberValidator
	@Size(max = 19, message = "{size.max19}")
	@Pattern(regexp = "[0-9]+", message = "{pattern.number}")
	private String creditcard_number;
	private BigDecimal balance = BigDecimal.ZERO;
	@Column
	@PositiveOrZero
	private BigDecimal maxlimit;
	@Column
	private String currencyType;
	@CreationTimestamp
	@Column(updatable = false)
	Date dateCreated;
	@UpdateTimestamp
	Date lastModified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreditcard_number() {
		return creditcard_number;
	}

	public void setCreditcard_number(String creditcard_number) {
		this.creditcard_number = creditcard_number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getLimit() {
		return maxlimit;
	}

	public void setLimit(BigDecimal maxlimit) {
		this.maxlimit = maxlimit;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}
