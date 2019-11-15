package com.crm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = -6431346328703366899L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custid")
	private long custId;

	@Column(name = "tenantcode")
	private String tenantCode;

	@Column(name = "custname")
	private String custName;

	@Column(name = "Lastname")
	private String lastName;

	@Column(name = "customertype")
	private String customerType;

	@Column(name = "connectionseq")
	private int connectionSeq;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email")
	private String email;

	@Column(name = "addr1")
	private String addr1;

	@Column(name = "addr2")
	private String addr2;

	@Column(name = "district")
	private String district;

	@Column(name = "mandal")
	private String mandal;

	@Column(name = "village")
	private String village;

	@Column(name = "state")
	private String state;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "landline")
	private String landline;

	@Column(name = "package")
	private String packageName;

	@Column(name = "onuserialno")
	private String onuSerialNo;

	@Column(name = "onumacaddress")
	private String onuMacAddrs;

	@Column(name = "iptvserialno")
	private String iptvSerialNo;

	@Column(name = "iptvmacaddress")
	private String iptvMacAddrs;

	@Column(name = "latitude")
	private String lattitude;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "activedate")
	private Date activeDate;

	@Column(name = "deactivedate")
	private Date deactiveDate;

	@Column(name = "status")
	private int status;

	@Column(name = "createdon")
	private Date createdOn;

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getTenantCode() {
		return tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public int getConnectionSeq() {
		return connectionSeq;
	}

	public void setConnectionSeq(int connectionSeq) {
		this.connectionSeq = connectionSeq;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getOnuSerialNo() {
		return onuSerialNo;
	}

	public void setOnuSerialNo(String onuSerialNo) {
		this.onuSerialNo = onuSerialNo;
	}

	public String getOnuMacAddrs() {
		return onuMacAddrs;
	}

	public void setOnuMacAddrs(String onuMacAddrs) {
		this.onuMacAddrs = onuMacAddrs;
	}

	public String getIptvSerialNo() {
		return iptvSerialNo;
	}

	public void setIptvSerialNo(String iptvSerialNo) {
		this.iptvSerialNo = iptvSerialNo;
	}

	public String getIptvMacAddrs() {
		return iptvMacAddrs;
	}

	public void setIptvMacAddrs(String iptvMacAddrs) {
		this.iptvMacAddrs = iptvMacAddrs;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public Date getDeactiveDate() {
		return deactiveDate;
	}

	public void setDeactiveDate(Date deactiveDate) {
		this.deactiveDate = deactiveDate;
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

}
