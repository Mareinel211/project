package com.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.Invoice;


public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

}