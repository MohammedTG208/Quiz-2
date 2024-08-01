package com.example.school.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
//    ID , name , salary ( all should not be empty).
    @NotNull(message = "the ID is requirement")
    @Positive(message = "Enter Positive ID number")
    private int id;
    @NotEmpty(message = "the name is requirement")
    @Size(min = 3,message = "the min char is 3 for name")
    private String name;
    @NotNull(message = "The salary is requirement")
    @Positive(message = "Enter positive number for salary")
    private double salary;
}
