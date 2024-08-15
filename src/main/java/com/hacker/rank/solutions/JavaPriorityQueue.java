package com.hacker.rank.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JavaPriorityQueue {

  private static final String ENTER_OP = "ENTER";
  private static final String SERVED = "SERVED";
  public static void main(String[] args) {
      /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner scan = new Scanner(System.in);
      int noOfStudents = scan.nextInt();
      PriorityQueue<Student> studentsQ = new PriorityQueue<Student>(noOfStudents, new StudentComparator());
      for (int i=1; i<=noOfStudents; i++) {
        String op = scan.next();
        if(ENTER_OP.equalsIgnoreCase(op)) {
          String name = scan.next();
          double cgpa = scan.nextDouble();
          int id = scan.nextInt();
          Student student = new Student(id, name, cgpa);
          studentsQ.add(student);
        } else if(SERVED.equalsIgnoreCase(op)) {
          Student student = studentsQ.poll();
          if(student == null) {
            
          }
        }
      }
        if(studentsQ.isEmpty()) {
          System.out.println("EMPTY");
        } else {
          while(!studentsQ.isEmpty()) {
            System.out.println(studentsQ.poll().getName());
          }
        }
  }
}

class StudentComparator implements Comparator<Student>{
  
  @Override
  public int compare(Student s1, Student s2){
    if(s1.getCGPA() != s2.getCGPA())
        return s2.getCGPA() - s1.getCGPA() > 0 ? 1 : -1;
    else{
        if(!s1.getName().equals(s2.getName())) return s1.getName().compareTo(s2.getName());
        else return s1.getID() < s2.getID() ? 1: -1;
    }
  }
}

class Student{
  private int id;
  private String name;
  private double cgpa;
  
  public Student(int id, String name, double cgpa) {
      this.id = id;
      this.name = name;
      this.cgpa = cgpa;
  }
  
  
  public String getName(){
      return this.name;
  }
  
  public int getID(){
      return this.id;
  }
  
  public double getCGPA(){
      return this.cgpa;
  }
  

}
