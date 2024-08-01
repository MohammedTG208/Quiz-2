package com.example.school.Service;

import com.example.school.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
//    Get all students
//Add new student
//update student
//delete student
    ArrayList<Student> students = new ArrayList<Student>();

    public ArrayList<Student> getStudents() {
        return students.isEmpty()?null:students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean updateStudent(Student student,int id) {
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }



    public Student getStudentByName(String name) {
        for(int i=0;i<students.size();i++){
            if(students.get(i).getName().equalsIgnoreCase(name)){
                return students.get(i);
            }
        }
        return null;
    }

    public ArrayList<Student> getStudentsByMajor(String major) {
        ArrayList<Student> getStudentsMajor =new ArrayList<>();
        for(int i=0;i<students.size();i++){
            if (students.get(i).getMajor().equalsIgnoreCase(major)){
                getStudentsMajor.add(students.get(i));
            }
        }
        return getStudentsMajor.isEmpty()?null: getStudentsMajor;
    }

}
