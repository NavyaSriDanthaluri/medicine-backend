package com.medicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicine.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> , IMedicineCustomRepository{

}
