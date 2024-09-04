package lab2.ans2.prob2A.execute;

import lab2.ans2.prob2A.*;

class Main {
    public static void main(String[] args) {
        Student group6 = new Student("Group 6", "10");

        GradeReport gr = group6.getGr();
        Student associatedStudent = gr.getStudent();

        System.out.println("Student Name: " + associatedStudent.getName());
        System.out.println("Grade: " + gr.getGrade());
    }
}