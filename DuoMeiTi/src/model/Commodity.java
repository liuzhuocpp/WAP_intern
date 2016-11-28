package model;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Commodity {
	
	
	
	public Commodity(int id, String type, String name, double price, String price_unit) {		 
		this.id = id;
		this.type = type;
		this.name = name;
		
		this.purchasePrice = price;
		this.purchasePriceUnit = price_unit;
		this.status = CommodityStatus.IN_STOREHOUSE;
	}

	int id;
    String name;
    String type;
    double purchasePrice;
    String purchasePriceUnit;
    CommodityStatus status;
   	int positionId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getPurchasePriceUnit() {
		return purchasePriceUnit;
	}
	public void setPurchasePriceUnit(String purchasePriceUnit) {
		this.purchasePriceUnit = purchasePriceUnit;
	}
	public CommodityStatus getStatus() {
		return status;
	}
	public void setStatus(CommodityStatus status) {
		this.status = status;
	}
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	
 	

	
}
