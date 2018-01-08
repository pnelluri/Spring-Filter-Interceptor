package com.nisum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nisum.model.Person;
import com.nisum.service.PersonService;

@Controller
@RequestMapping("/search")
public class PersonAPI {

	@Autowired
	private PersonService personService;

	@RequestMapping("/person")
	public @ResponseBody Person  searchStudent(@RequestParam(name = "personId", required = true) 
				Integer personId) {
		Person person = personService.getPersonById(personId);
		ModelAndView model = new ModelAndView();
		model.setViewName("MaintenancePage");
		model.addObject("person",person);

		model.addObject("classname", "MaintenanceController");
		
		System.out.println("In swearch Student");
		return person;
	}
}
