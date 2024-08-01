package com.example.school.Controller;

import com.example.school.Model.Student;
import com.example.school.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents() {
        if(studentService.getStudents()==null){
            return ResponseEntity.status(400).body("There are No students");
        }else {
            return ResponseEntity.status(200).body(studentService.getStudents());
        }
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            studentService.addStudent(student);
            return ResponseEntity.status(201).body("Student added successfully");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student, Errors errors,@PathVariable int id) {
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            if(studentService.updateStudent(student,id)){
                return ResponseEntity.status(201).body("Student updated successfully");
            }else {
                return ResponseEntity.status(400).body("Student update failed check the id");
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        if(studentService.deleteStudent(id)){
            return ResponseEntity.status(201).body("Student deleted successfully");
        }else {
            return ResponseEntity.status(400).body("Student delete failed check the id");
        }
    }

    @GetMapping("/get/by/name/{name}")
    public ResponseEntity getByName(@PathVariable String name) {
        if(studentService.getStudentByName(name)==null){
            return ResponseEntity.status(400).body("No student by this name found check the name");
        }else {
            return ResponseEntity.status(200).body(studentService.getStudentByName(name));
        }
    }

    @GetMapping("/get/by/major/{major}")
    public ResponseEntity getMajor(@PathVariable String major) {
        if (studentService.getStudentsByMajor(major)==null){
            return ResponseEntity.status(400).body("No students by this major found check the major");
        }else {
            return ResponseEntity.status(200).body(studentService.getStudentsByMajor(major));
        }
    }

}
