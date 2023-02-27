package com.medicine.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "medicines")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicineId;
	private String medicineName;
	private String manufacturedDate;
	private String expiryDate;
	private Integer medicinePrice;
	
	/*@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "medicineId")
	private List<Review> reviews;*/

	public Medicine(Long medicineId, String medicineName, String manufacturedDate, String expiryDate,
			Integer medicinePrice){//, List<Review> reviews) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.manufacturedDate = manufacturedDate;
		this.expiryDate = expiryDate;
		this.medicinePrice = medicinePrice;
		//this.reviews = reviews;
	}

	public Medicine(String medicineName, Integer price, String manufacturedDate, String expiryDate) {
		super();
	}
	

	public Medicine() {
		super();
	}

	public Long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(String manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(Integer medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	/*public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}*/

	
}
