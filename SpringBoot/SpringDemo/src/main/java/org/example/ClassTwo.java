package org.example;

import org.springframework.stereotype.Component;

@Component
public class ClassTwo {
    public final ClassOne classOne;

    public ClassTwo(ClassOne classOne){
        this.classOne = classOne;
    }

    public void displayMsg(){
        classOne.msg();
    }
}
