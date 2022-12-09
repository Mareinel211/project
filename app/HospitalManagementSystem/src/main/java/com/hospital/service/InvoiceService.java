package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.entity.Invoice;
import com.hospital.repository.InvoiceRepository;

@Service
@Transactional
public class InvoiceService {

	@Autowired
	private InvoiceRepository rep;
	
	
	public void save(Invoice entity) {
		rep.save(entity);
	}
	
	public List<Invoice> view(){
		return rep.findAll();
	}
}
