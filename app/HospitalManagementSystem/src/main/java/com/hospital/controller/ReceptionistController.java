package com.hospital.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hospital.entity.Appointment;
import com.hospital.entity.Event;
import com.hospital.entity.Invoice;
import com.hospital.repository.EventJpaRepository;
import com.hospital.service.AppointmentService;

@Controller
@RequestMapping("/receptionist")
public class ReceptionistController {

	@Autowired
	private AppointmentService service ;


	@Autowired
	EventJpaRepository repository;

	
	@GetMapping("/receptionistAppointments")
	public String showReceptionistAppointments(Model model) {
		List<Appointment> listAppointments = service.listAll();
		model.addAttribute("listAppointments", listAppointments);

		String confirmed = "confirmed";
		model.addAttribute("confirmed", confirmed);
		return "receptionistAppointments";

	}

	@GetMapping("/confirmm")
	public String showConfirmm(Model model) {
		Appointment confirmation = new Appointment();
		model.addAttribute("confirmation", confirmation);
		return "confirm";
	}

	@RequestMapping(value = "/receptionistSchedule", method = RequestMethod.GET)
	public String receptionistSchedule(Model model) {
		List<Event> events = repository.findAll();
		model.addAttribute("events", events);
		return "receptionistSchedule";
	}

	@RequestMapping("/findbystart")
	public String showBydate(Model model) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		System.out.println(now);
		List<Event> event = repository.findByStart(now);
		model.addAttribute("event", event);
		return "scheduleFindByName";
	}

	@RequestMapping("/createInvoice")
	public String createInvoice(Model model) {
		Invoice i = new Invoice();
		model.addAttribute("invoice", i);
		return "invoice";
	}

}
