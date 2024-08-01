package com.example.school.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "Enter value for id")
    @Positive(message = "Enter positive ID number")
    private int id;
    @NotEmpty(message = "Enter your name")
    @Size(min = 3,message = "the min char 3 for name")
    private String name;
    @NotNull(message = "Enter your age")
    @Min(value = 6 , message = "the min value for age is 6")
    private int age;
    @NotEmpty(message = "Enter your major")
    private String major;
}
