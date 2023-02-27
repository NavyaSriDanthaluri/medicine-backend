package com.medicine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineResponseDTO implements MyDTO {
	
	private Long medicineId;
	private String medicineName;
	private Integer medicinePrice;
	
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
	public Integer getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(Integer medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
	
	public MedicineResponseDTO(Long medicineId, String medicineName, Integer medicinePrice) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicinePrice = medicinePrice;
	}
	
	public MedicineResponseDTO() {
		super();
	}
	

}
