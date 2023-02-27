package com.medicine.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.medicine.entity.Medicine;
import com.medicine.repository.MedicineRepository;

@SpringBootTest
public class MedicineServiceImplTest {
	
	@Mock
	MedicineRepository medicineRepository;
	
	@InjectMocks
	MedicineServiceImpl medicineService;
	
	@Test
	@DisplayName("Test to verify al medicines returned")
	void testGetAllMedicines() throws Exception{
		
		Medicine medicine1 = new Medicine("Dolo" , 50 , "24/02/2022" , "23/02/2023");
		
		Medicine medicine2 = new Medicine("Paracetemol" , 150 , "25/06/2022" , "24/06/2023");
		
		List<Medicine> sampleOutput = new ArrayList<>();
		sampleOutput.add(medicine1);
		sampleOutput.add(medicine2);
		
		BDDMockito.given(medicineService.getAllMedicines()).willReturn(sampleOutput);
		
		List<Medicine> actualOutput = medicineService.getAllMedicines();
		
		assertNotNull(actualOutput);
		assertThat(actualOutput.size()).isGreaterThan(0);
		assertIterableEquals(sampleOutput, actualOutput);
		
	}
	
	@Test
	@DisplayName("Test to verify the insert operation")
	void testAddMedicine() throws Exception{
		
		Medicine sampleInput = new Medicine("Dolo", 50, "24/02/2023", "23/02/2024");
		Medicine expectedOutput = new Medicine("Dolo", 50, "24/02/2023", "23/02/2024");
		
		BDDMockito.given(medicineService.addMedicine(sampleInput)).willReturn(expectedOutput);
		
		Medicine actualOutput = medicineService.addMedicine(sampleInput);
		
		assertEquals(expectedOutput,actualOutput);
	}
	

}
