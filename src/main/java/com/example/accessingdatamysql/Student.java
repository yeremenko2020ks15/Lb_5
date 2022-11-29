package com.example.accessingdatamysql;

import org.springframework.stereotype.Component;

@Component("studentBean")
public class Student {

    private String name, surname, patronymic;
    private int age;


    public Student() {
        this.name = "Khruslov";
        this.surname = "Maksym";
        this.patronymic = "Mykhalovich";
        this.age = 17;
    }

    public Student(String name, String surname, String patronymic, int age) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
    }

    public void printName(){
        System.out.println("Name: " + name);
    }
    public void printSurname(){
        System.out.println("Surname: " + surname);
    }
}
