package com.medicine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medicine.entity.Medicine;

@Service
public interface MedicineService {
	
	public Medicine addMedicine(Medicine medicine) throws Exception;
	public Medicine getById(Long medicineId) throws Exception;
	public String deleteMedicine(long medicineId) throws Exception;
	public Medicine updateMedicine(Medicine medicine) throws Exception;
	public List<Medicine> getAllMedicines() throws Exception;
	public List<Medicine> sortMedicinesByName() throws Exception;
	public List<Medicine> sortByMedicinePrice() throws Exception;
}
