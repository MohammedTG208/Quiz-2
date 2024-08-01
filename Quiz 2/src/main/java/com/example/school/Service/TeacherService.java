package com.example.school.Service;

import com.example.school.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
//    Get all teachers
//Add new teacher
//update teacher
//delete teacher

    ArrayList<Teacher> teachers = new ArrayList<>();


    public ArrayList<Teacher> getAllTeachers() {
        return teachers.isEmpty()?null:teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean updateTeacher(Teacher teacher,int id) {
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id) {
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Teacher getTeacher(int id) {
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                return teachers.get(i);
            }
        }
        return null;
    }

    public ArrayList<Teacher> getTeacherBySalary(double salary) {
        ArrayList<Teacher> newteachers = new ArrayList<>();
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getSalary()>=salary){
                newteachers.add(teachers.get(i));
            }
        }
        return newteachers.isEmpty()?null:newteachers;
    }
}