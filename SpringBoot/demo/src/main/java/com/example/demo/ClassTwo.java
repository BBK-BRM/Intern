package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassTwo {
    public final ClassOne classOne;

    public ClassTwo(ClassOne classOne){
        this.classOne = classOne;
    }

    public void displayMessage(){
        System.out.println("Message : "+ classOne.getMessage());
    }
}
