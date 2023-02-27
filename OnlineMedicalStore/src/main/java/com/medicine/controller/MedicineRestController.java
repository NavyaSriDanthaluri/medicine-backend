package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.dto.ErrorDTO;
import com.medicine.dto.MedicineResponseDTO;
import com.medicine.dto.MyDTO;
import com.medicine.entity.Medicine;
import com.medicine.service.MedicineService;
import com.medicine.util.MedicineDTOConverter;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("/medicalstore")
public class MedicineRestController {

	@Autowired
	MedicineService medicineService;

	@Autowired
	MedicineDTOConverter dtoConverter;

	@PostMapping("/addmedicine")
	public ResponseEntity<MyDTO> addMedicine(@RequestBody Medicine medicine) {
		try {
			Medicine savedMedicine = medicineService.addMedicine(medicine);
			MedicineResponseDTO dto = MedicineDTOConverter.convertToDTO(savedMedicine);
			return new ResponseEntity<MyDTO>(dto, HttpStatus.OK);
		} catch (Exception e) {
			ErrorDTO errorDTO = new ErrorDTO(e.getMessage());
			return new ResponseEntity<MyDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{medicineId}")
	public ResponseEntity<String> deleteMedicine(@PathVariable Long medicineId) {
		try {
			String deletedMedicine = medicineService.deleteMedicine(medicineId);
			String responseMsg = "deleted the medicine selected";
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact concerned manager \n" + e;
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public Medicine updateMedicine(@RequestBody Medicine medicineDetails) throws Exception {
		return medicineService.updateMedicine(medicineDetails);
	}
	
	@GetMapping("/medicineid/{medicineId}")
	public Medicine getMedicineById(@PathVariable Long medicineId) throws Exception {
		return medicineService.getById(medicineId);
	}
	

	@GetMapping("/medicines")
	public List<Medicine> getAllMedicines() {
		try { 
			List<Medicine> allExtractedMedicines = medicineService.getAllMedicines();
			return allExtractedMedicines;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
}
	
	@GetMapping("/sortbyprice")
	public List<Medicine> sortByPrice()throws Exception{
		return medicineService.sortByMedicinePrice();
		
	}
	
	@GetMapping("/sortbyname")
	public List<Medicine> sortByName() throws Exception{
		return medicineService.sortMedicinesByName();
	}

}