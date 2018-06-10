package com.cts.product.rental.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "step", "status", "confNum", "pickupDateTime", "returnDateTime", "pickupLoc", "returnLoc",
	"carType", "vehicleRentPrice", "consessionFee", "salesTax", "estimatedTotal" })
public class Reservation {

	private String step;
	private String status;
	private String confNum;
	private Date pickupDateTime;
	private Date returnDateTime;
	private String pickupLoc;
	private String returnLoc;
	private String carType;
	private String vehicleRentPrice;
	private String consessionFee;
	private String salesTax;
	private String estimatedTotal;

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConfNum() {
		return confNum;
	}

	public void setConfNum(String confNum) {
		this.confNum = confNum;
	}

	public Date getPickupDateTime() {
		return pickupDateTime;
	}

	public void setPickupDateTime(Date pickupDateTime) {
		this.pickupDateTime = pickupDateTime;
	}

	public Date getReturnDateTime() {
		return returnDateTime;
	}

	public void setReturnDateTime(Date returnDateTime) {
		this.returnDateTime = returnDateTime;
	}

	public String getPickupLoc() {
		return pickupLoc;
	}

	public void setPickupLoc(String pickupLoc) {
		this.pickupLoc = pickupLoc;
	}

	public String getReturnLoc() {
		return returnLoc;
	}

	public void setReturnLoc(String returnLoc) {
		this.returnLoc = returnLoc;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getVehicleRentPrice() {
		return vehicleRentPrice;
	}

	public void setVehicleRentPrice(String vehicleRentPrice) {
		this.vehicleRentPrice = vehicleRentPrice;
	}

	public String getConsessionFee() {
		return consessionFee;
	}

	public void setConsessionFee(String consessionFee) {
		this.consessionFee = consessionFee;
	}

	public String getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(String salesTax) {
		this.salesTax = salesTax;
	}

	public String getEstimatedTotal() {
		return estimatedTotal;
	}

	public void setEstimatedTotal(String estimatedTotal) {
		this.estimatedTotal = estimatedTotal;
	}

}