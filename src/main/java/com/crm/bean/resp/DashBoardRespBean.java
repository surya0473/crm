package com.crm.bean.resp;

public class DashBoardRespBean {
	private long totalCustomers;
	private long activeCustomers;
	private long inActiveCustomers;
	private double totalBill;
	private double paidAmount;
	private double unPaidAmount;

	public long getTotalCustomers() {
		return totalCustomers;
	}

	public void setTotalCustomers(long totalCustomers) {
		this.totalCustomers = totalCustomers;
	}

	public long getActiveCustomers() {
		return activeCustomers;
	}

	public void setActiveCustomers(long activeCustomers) {
		this.activeCustomers = activeCustomers;
	}

	public long getInActiveCustomers() {
		return inActiveCustomers;
	}

	public void setInActiveCustomers(long inActiveCustomers) {
		this.inActiveCustomers = inActiveCustomers;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getUnPaidAmount() {
		return unPaidAmount;
	}

	public void setUnPaidAmount(double unPaidAmount) {
		this.unPaidAmount = unPaidAmount;
	}

}
