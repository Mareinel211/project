package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.entity.Prescription;
import com.hospital.repository.PrescriptionRepository;

@Service
@Transactional
public class PrescriptionService {
	
	@Autowired
	private PrescriptionRepository repository;
	
	public void save(Prescription Prescription) {
		repository.save(Prescription);
	}
	
	public List<Prescription> findByPatientName(String patientName){
		
			return repository.findByPatientName(patientName);
	}
}
