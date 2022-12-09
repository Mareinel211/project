package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.hospital.entity.Appointment;
import com.hospital.service.AppointmentService;

@Controller
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private AppointmentService service;

	@GetMapping("/myAppointments")
	public String myAppointments(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String patientName = authentication.getName();
		List<Appointment> listAppointments = service.findByPatientName(patientName);
		model.addAttribute("listAppointments", listAppointments);
		return "myAppointments";
	}

	@GetMapping("/cancelAppointment")
	public String cancelAppointment(Model model) {
		Appointment cancelAppointment = new Appointment();
		model.addAttribute("appointment", cancelAppointment);
		return "cancelAppointment";

	}

}
