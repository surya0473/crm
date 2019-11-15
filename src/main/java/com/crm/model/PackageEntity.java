package com.crm.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "packages")
public class PackageEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Sl_No")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger sno;

	@Column(name = "tenantcode")
	private String username;

	@Column(name = "packagename")
	private String packagename;

	@Column(name = "services")
	private String services;

	@Column(name = "chargeamt")
	private double chargeAmt;

	@Column(name = "status")
	private int status;

	@Column(name = "createdon")
	private Date createdOn;

	@Column(name = "createdby")
	private String createdBy;

	@Column(name = "modifiedon")
	private Date modifiedOn;

	@Column(name = "modifiedby")
	private String modifiedBy;

	public BigInteger getSno() {
		return sno;
	}

	public void setSno(BigInteger sno) {
		this.sno = sno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPackagename() {
		return packagename;
	}

	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public double getChargeAmt() {
		return chargeAmt;
	}

	public void setChargeAmt(double chargeAmt) {
		this.chargeAmt = chargeAmt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
