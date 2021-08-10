/*
 * Copyright (C) 2021 Timothy McCaul
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package csit121;

import java.util.ArrayList;

/**
 *
 * @author Timothy McCaul
 */
public class Lab01Task2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Course BSCompSci = new Course("Bachelor of Computer Science");
        
        Subject CSIT111 = new Subject("Programming Fundamentals", "CSIT111", "Spring", "2021");
        Subject CSIT121 = new Subject("Object Oriented Design and Programming", "CSIT121", "Spring", "2021");
        
        Student amy = new Student("Amy Bell", " 01/01/2001", "Female", 100001);
        Student bob = new Student("Bob Brown", " 02/02/2002", "Male", 100002);
        Student cindy = new Student("Cindy Ma", " 03/03/2001", "Female", 100003);
        Student david = new Student("David Hintz", "04/04/2000", "Male", 100004);
        
        // Add the Subjects and Students to the course.
        BSCompSci.addSubject(CSIT111);
        BSCompSci.addSubject(CSIT121);
        BSCompSci.enrolStudent(amy);
        BSCompSci.enrolStudent(bob);
        BSCompSci.enrolStudent(cindy);
        BSCompSci.enrolStudent(david);
        
        
        // Add the students to their subjects
        CSIT111.enrolStudent(amy);
        CSIT111.enrolStudent(bob);
        CSIT111.enrolStudent(cindy);
        CSIT121.enrolStudent(david);
        
        System.out.println(BSCompSci); // Java automatically uses the toString() method.
        
        System.out.println("-----------------");
        
        CSIT111.withdrawStudent(cindy);
        CSIT121.enrolStudent(cindy);
        
        System.out.println(BSCompSci);
    }
}

class Course {
    private String name;
    private ArrayList<Student> studentList;
    private ArrayList<Subject> subjectList;
    
    // Default constructor
    public Course() {
        this("");
    }
    
    // Parameterized constructor
    // Takeaway: An example of overloading a method
    public Course(String name) {
        this.name = name;
        studentList = new ArrayList<Student>();
        subjectList = new ArrayList<Subject>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addSubject(Subject subject) {
        if (!subjectList.contains(subject)) {
            subjectList.add(subject);
        } else {
            System.out.println("Error: Subject " + subject.getCode() + " already exists within " + name);
        }
    }
    
    public void removeSubject(Subject subject) {
        if (subjectList.contains(subject)) {
            subjectList.remove(subject);
        } else {
            System.out.println("Error: Subject " + subject.getCode() + " cannot be removed from " + name + " as it is not on the subject list");
        }
    }
    
    public void enrolStudent(Student student) {
        if (!studentList.contains(student)) {
            studentList.add(student);
        } else {
             System.out.println("Error: Student " + student.getName() + " is already enrolled in " + name);
        }
    }
    
    public void withdrawStudent(Student student) {
        if (studentList.contains(student)) {
            studentList.remove(student);
        } else {
             System.out.println("Error: Student " + student.getName() + " is not enrolled in " + name + " and cannot be removed");
        }
    }
    
    // Takeaway: Overriding the Java toString() method.
    public String toString() {
        String result = "Course Name: " + name + "\n";
        
        for (Subject sub : subjectList) {
            result += sub + "\n";   // Java automatically calls the Subject.toString() method
        }
        
        return result;
    }
}

class Subject {
    private String name;
    private String code;
    private String session;
    private String year;
    private ArrayList<Student> studentList;

    public Subject() {
        studentList = new ArrayList<Student>();
    }

    public Subject(String name, String code, String session, String year) {
        this.name = name;
        this.code = code;
        this.session = session;
        this.year = year;
        studentList = new ArrayList<Student>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public void enrolStudent(Student student) {
        if (!studentList.contains(student)) {
            studentList.add(student);
        } else {
             System.out.println("Error: Student " + student.getName() + " is already enrolled in " + name);
        }
    }
    
    public void withdrawStudent(Student student) {
        if (studentList.contains(student)) {
            studentList.remove(student);
        } else {
             System.out.println("Error: Student " + student.getName() + " is not enrolled in " + name + " and cannot be removed");
        }
    }
    
    // Takeaway: Overriding the Java toString() method.
    public String toString() {
        String result = "Subject Name: " + name + " (" + code;
        result += ", " + session + " " + year + ")\n";
        result += "Enrolled Students:\n";
        
        for (Student student : studentList) {
            result += student + "\n"; // Java automatically calls the Student.toString() method
        }
        
        return result;
    }
}

class Student {
    private String name;
    private String dob;
    private String gender;
    private int number;
    
    public Student() {
        name = "";
        dob = "";
        gender = "";
        number = 0;
    }
    
    public Student(String name, String dob, String gender, int number) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    // Takeaway: Overriding the Java toString() method.
    public String toString() {
        return name + "\t(" + number + ")";
    }
}
