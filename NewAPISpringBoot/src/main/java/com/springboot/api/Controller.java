package com.springboot.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  
	@Autowired
	public StudentsService studentService;
	
	
	//get all students
	
	@GetMapping("/students")
	public ArrayList<Students> getStudents() {
		
		//ArrayList<Students> list= new ArrayList<Students>();
		//list.add(new Students(1,"Anjali","CSE","Raipur"));
		
		return this.studentService.getStudents();
		//return list;
	}
	
	
	//get students by id
	
		@GetMapping("/students/{id}")
		public Students studentbyId(@PathVariable("id") int id) {
			return this.studentService.getStudentsById(id);
		}
		
		
		//add students 
		
		@PostMapping("/students")
		public Students addBooks(@RequestBody Students s) {
			 return this.studentService.addStudent(s);
		}
		

		//delete a book by id
		@DeleteMapping("/students/{id}")
		public Students deleteBook(@PathVariable("id") int id) {
			return this.studentService.deleteById(id);
		}
		
		@PutMapping("/students/{id}")
		public Students updateBook(@RequestBody Students s,@PathVariable("id") int id) {
			return this.studentService.updateById(s, id);
		}
}
