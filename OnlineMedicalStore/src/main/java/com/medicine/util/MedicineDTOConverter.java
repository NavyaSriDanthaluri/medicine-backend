package com.medicine.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.medicine.dto.MedicineResponseDTO;
import com.medicine.entity.Medicine;

@Component
@Scope("singleton")
public class MedicineDTOConverter {
	
	 public static MedicineResponseDTO convertToDTO(Medicine medicine) {
		 
		return new MedicineResponseDTO(medicine.getMedicineId(),medicine.getMedicineName(),medicine.getMedicinePrice());
		 
	 }

}
