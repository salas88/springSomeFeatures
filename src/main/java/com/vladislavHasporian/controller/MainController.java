package com.vladislavHasporian.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vladislavHasporian.entity.Student;
import com.vladislavHasporian.service.IStudentService;

@Controller
@RequestMapping("/")
public class MainController {
	
	private IStudentService studentService;

	@Autowired
	public MainController(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimerEditor);
	}
	
	@GetMapping
	public String findAll(Model theModel) {
		
		List<Student> students = studentService.findAll();
		
		theModel.addAttribute("students", students);
		
		return "list-student";
	}
	
	@GetMapping("/addNewStudent")
	public String showFormForAdd(Model theModel) {
		
		Student student = new Student();

		theModel.addAttribute("student", student);
		
		return "form";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveorUpdate(@Valid @ModelAttribute Student theStudent,
							   BindingResult theBindingResult) {
		if(theBindingResult.hasErrors())
			return "form";
		else
		studentService.save(theStudent);
		
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updateStudent(@RequestParam("id") int theId, Model theModel) {
		
	
		Optional<Student> student = studentService.findById(theId);
		
		theModel.addAttribute("student", student);
		
		return "form";
		
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("id") int theId) {
		
		studentService.delete(theId);
		
		return "redirect:/";
	}
}
