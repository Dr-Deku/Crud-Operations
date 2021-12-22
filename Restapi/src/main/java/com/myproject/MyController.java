package com.myproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	StudentRepository studentrepo;
	
	@GetMapping("/students")
	public List<Student> getStudent(){
		return this.studentrepo.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student getOneStudent(@PathVariable int id) {
		return this.studentrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("NOT IN DATABASE"));
	}
	
	@PostMapping("/students")
	public Student createstudent(@RequestBody Student student) {
		return this.studentrepo.save(student);
	}
	
	@PutMapping("/students/{id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable int id) {
		Student existing = this.studentrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("NOT IN DATABASE"));
		existing.setSid(student.getSid());
		existing.setSname(student.getSname());
		existing.setSdob(student.getSdob());
		existing.setSdoj(student.getSdoj());
		return this.studentrepo.save(existing);
	}
	
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
		Student existing = this.studentrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("NOT IN DATABASE"));
		this.studentrepo.delete(existing);
		return ResponseEntity.ok().build();
		
	}
	

}
