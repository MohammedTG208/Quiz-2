package com.example.school.Controller;

import com.example.school.Model.Teacher;
import com.example.school.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeacher() {
        if (teacherService.getAllTeachers()==null){
            return ResponseEntity.status(400).body("there are no teachers found");
        }else {
            return ResponseEntity.status(200).body(teacherService.getAllTeachers());
        }
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            teacherService.addTeacher(teacher);
            return ResponseEntity.status(201).body("Teacher add successfully");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher( @Valid @RequestBody Teacher teacher, Errors errors,@PathVariable int id) {
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            if (teacherService.updateTeacher(teacher,id)){
                return ResponseEntity.status(201).body("Teacher update successfully");
            }else {
                return ResponseEntity.status(400).body("Teacher update failed check id");
            }
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id) {
        if (teacherService.deleteTeacher(id)){
            return ResponseEntity.status(201).body("Teacher delete successfully");
        }else {
            return ResponseEntity.status(400).body("Teacher delete failed check id");
        }
    }


    @GetMapping("/search/{id}")
    public ResponseEntity searchTeacher(@PathVariable int id) {
        if (teacherService.getTeacher(id)==null){
            return ResponseEntity.status(400).body("This Teacher not found");
        }else {
            return ResponseEntity.status(200).body(teacherService.getTeacher(id));
        }
    }

    @GetMapping("/get/by/{salary}")
    public ResponseEntity getTeacherBySalary(@PathVariable double salary) {
        if (teacherService.getTeacherBySalary(salary)==null){
            return ResponseEntity.status(400).body("no one have this salary");
        }else {
            return ResponseEntity.status(200).body(teacherService.getTeacherBySalary(salary));
        }
    }
}
