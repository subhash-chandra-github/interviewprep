package com.interviewprep.coreJava;

public class Student {

    private String name;
    private int age;

    // Constructor
    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public Student()
    {
    }

    // Getters and setters
    private String getName() { return name; }

  //  public void setName(String name) { this.name = name; }

    private int getAge() { return age; }

  //  public void setAge(int age) { this.age = age; }

    // Override toString method to get required
    // output at terminal
    @Override public String toString()
    {
        return "Student [name=" + name + ", age=" + age
                + "]";
    }
}
