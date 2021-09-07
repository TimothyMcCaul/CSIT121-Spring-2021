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

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Timothy McCaul
 */
public class Lab03Task2 {
}


class Enrollment {
    private Student student;
    private String name;
    private Major major;
    private ArrayList<Subject> cores;
    private ArrayList<Subject> electives;
    private int totalCredits;
    
    public static void main(String[] args) {
        
        Course bcs = CreateCourse();
       
        System.out.println(bcs);
        
        Student student = CreateStudent();
        Enrollment enrollment = new Enrollment(student, "Test enrollment");
        enrollment.enrolCores(bcs.getCores());
        
        MajorEnrollment(bcs, enrollment);
                
        ElectiveEnrollment(bcs, enrollment);
        
        System.out.println("Congratulations. You had completed the enrolment to Bachelor of Computer Science course.");
        System.out.println("-----------------");
        System.out.println(enrollment);
    }
    
    public Enrollment() {}
    
    public Enrollment(Student student, String name) {
        this.student = student;
        this.name = name;
        cores = new ArrayList<Subject>(); // Not needed but prevents a NullReferenceException if enrolCores() isn't called
        electives = new ArrayList<Subject>();
    }
    
    public static Course CreateCourse() {
        Subject CSIT111 = new Subject("CSIT111", "Programming Fundamentals", 6);
        Subject CSIT113 = new Subject("CSIT113", "Problem Solving", 6);
        Subject CSIT114 = new Subject("CSIT114", "System Analysis", 6);
        Subject CSIT115 = new Subject("CSIT115", "Data Management and Security", 6);
        Subject CSIT121 = new Subject("CSIT121", "Object Oriented Design and Programming", 6);
        Subject CSIT127 = new Subject("CSIT127", "Networks and Comunitcations", 6);
        Subject CSIT128 = new Subject("CSIT128", "Introduction to Web Technology", 6);
        Subject CSCI235 = new Subject("CSCI235", "Database Systems", 6);
        Subject CSCI251 = new Subject("CSCI251", "Advanced Programming", 6);
        Subject CSIT214 = new Subject("CSIT214", "IT Project Management", 6);
        Subject MATH221 = new Subject("MATH221", "Mathematics for Computer Science", 6);
        Subject CSCI203 = new Subject("CSCI203", "Algorithms and Data Structures", 6);
        Subject CSIT226 = new Subject("CSIT226", "Human Computer Interaction", 6);
        Subject CSIT314 = new Subject("CSIT314", "Software Development Methodologies", 6);
        Subject CSIT321 = new Subject("CSIT321", "Project", 12);
        Subject CSCI317 = new Subject("CSIT317", "Database Performance Tuning", 6);
        Subject INFO411 = new Subject("INFO411", "Data Mining and Knowledge Discovery", 6);
        Subject CSCI316 = new Subject("CSCI316", "Big Data Mining Techniques and Implementation", 6);
        Subject ISIT312 = new Subject("ISIT312", "Big Data Management", 6);
        Subject CSCI301 = new Subject("CSCI301", "Contemporary Topics in Security", 6);
        Subject CSCI262 = new Subject("CSCI262", "System Security", 6);
        Subject CSCI369 = new Subject("CSCI369", "Ethical Hacking", 6);
        Subject CSIT302 = new Subject("CSIT302", "Cybersecurity", 6);
        Subject CSCI361 = new Subject("CSCI361", "Cryptography and Secure Applications", 6);
        Subject CSCI368 = new Subject("CSCI368", "Network Security", 6);
        Subject CSCI376 = new Subject("CSCI376", "Multicore and GPU Programming", 6);
        Subject CSCI236 = new Subject("CSCI236", "3D Moddelling and Animation", 6);
        Subject CSCI336 = new Subject("CSCI336", "Interactive Computer Graphics", 6);
        Subject CSCI366 = new Subject("CSCI366", "Mobile Multimedia", 6);
        Subject CSCI356 = new Subject("CSCI356", "Game Engine Essentials", 6);
        Subject CSCI334 = new Subject("CSCI334", "Software Design", 6);
        Subject ISIT219 = new Subject("ISIT219", "Knowledge and Information Engineering", 6);
        Subject CSCI318 = new Subject("CSCI318", "Software Engineering Practices & Principles", 6);
        Subject ISIT315 = new Subject("ISIT315", "Semantic Web", 6);

        Major bigData = new Major("Big Data");
        Subject[] bigDataCores = {CSCI317, INFO411, CSCI316, ISIT312};
        bigData.addCores(bigDataCores);
        
        Major cyberSec = new Major("Cyber Security");
        Subject[] cyberSecCores = {CSCI301, CSCI262, CSCI369, CSIT302};
        cyberSec.addCores(cyberSecCores);
        
        Major digitalSystemSec = new Major("Digital System Security");
        Subject[] digitalSystemSecCores = {CSCI361, CSCI262, CSCI368, CSCI376};
        digitalSystemSec.addCores(digitalSystemSecCores);
        
        Major gameMobileDev = new Major("Game and Mobile Development");
        Subject[] gameMobileDevCores = {CSCI236, CSCI336, CSCI366, CSCI356, CSCI376};
        gameMobileDev.addCores(gameMobileDevCores);

        Major softwareEng = new Major("Software Engineering");
        Subject[] softwareEngCores = {CSCI334, ISIT219, CSCI318, ISIT315};
        softwareEng.addCores(softwareEngCores);

        Major[] bcsMajors = {bigData, cyberSec, digitalSystemSec, gameMobileDev, softwareEng};
        
        Subject[] bcsCores = {CSIT111, CSIT113, CSIT114, CSIT115, CSIT121, CSIT127, CSIT128, CSCI235,
                    CSCI251, CSIT214, MATH221, CSCI203, CSIT226, CSIT314, CSIT314, CSIT321};
        
        Subject[] bcsElectives = {CSCI317, INFO411, CSCI316, ISIT312, CSCI301, CSCI262,
                    CSCI369, CSIT302, CSCI361, CSCI368, CSCI376, CSCI236, CSCI336,
                    CSCI366, CSCI356, CSCI334, ISIT219, CSCI318, ISIT315};

        Course bcs = new Course("Bachelor of Computer Science");
        bcs.addCores(bcsCores);
        bcs.addMajors(bcsMajors);
        bcs.addElectives(bcsElectives);

        return bcs;
    }
    
    public static Student CreateStudent() {
        System.out.println("-----------------");
        System.out.println("Your following personal information are required to complete the enrolment.");
        
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please input your full name: ");
        String studentName = userInput.nextLine();
        System.out.print("Please input your student number: ");
        int studentNumber = userInput.nextInt();
        userInput.nextLine(); // Use the newline character that is sitting in the input stream.
        System.out.print("Please input your gender: ");
        String studentGender = userInput.nextLine();
        System.out.print("Please input your date of birth (dd/mm/yyyy): ");
        String studentDOB = userInput.nextLine();
        
        System.out.println("Thanks for your information.");
        
        return new Student(studentName, studentGender, studentDOB, studentNumber);
    }
    
    public static void MajorEnrollment(Course bcs, Enrollment enrollment) {
        System.out.println("In order to complete the enrolment, please select a major from the list.");
        ArrayList<Major> bcsMajorsList = bcs.getMajors();
        for(int i = 0; i < bcsMajorsList.size(); i++) {
            System.out.println(i+1 + ": " + bcsMajorsList.get(i).getName());
        }
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("Please input the index number before the major: ");
        int selectedMajor = userInput.nextInt();
        userInput.nextLine(); // Use the newline character that is sitting in the input stream.
        selectedMajor--; // Arrays start at 0
        System.out.println("You enrolled into:");
        System.out.println(bcsMajorsList.get(selectedMajor));
        enrollment.enrolMajor(bcsMajorsList.get(selectedMajor));
    }
    
    public static void ElectiveEnrollment(Course bcs, Enrollment enrollment) {
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("In order to complete the enrolment, please select selective subjects from the list.");
        System.out.println("Elective Subjects:");
        for(Subject subject : bcs.getElectives()) {
            System.out.println(subject);
        }
        System.out.println();
        
        boolean allElectivesSelected = false;
        int requiredCredits = 144;
        
        while(!allElectivesSelected) {
            int requiredSubjects = (int)Math.ceil((requiredCredits - enrollment.getTotalCredit()) / 6);
            System.out.print("Please select " + requiredSubjects + " more elective subjects:");
            
            String nextLine = userInput.nextLine(); // "CSCI369, CSCI368"
            String[] inputs =  nextLine.split(","); // {"CSCI369", " CSCI368"}
            for(String str : inputs) { // str = "CSCI369" on the first loop and str = " CSCI368" on the second
                // Takeaway: We can manipulate user input to be in the form we want.
                String input = str.trim().toUpperCase();
                
                // Find the elective and if found, enroll in it
                for(Subject subject : bcs.getElectives()) {
                    if(subject.getCode().equals(input)) {
                        enrollment.enrolElective(subject);
                    }
                }
            }
            
            if(enrollment.getTotalCredit() >= requiredCredits) {
                allElectivesSelected = true;
            }
        }
    }
    
    public void enrolCores(ArrayList<Subject> cores) {
        this.cores = cores;
        for(Subject sub : cores) {
            totalCredits += sub.getCredit();
        }
    }
    
    public void enrolMajor(Major major) {
        this.major = major;
        for(Subject sub : major.getCores()) {
            totalCredits += sub.getCredit();
        }
    }
    
    public void enrolElective(Subject subject) {
        if(!isEnrolled(subject)) {
            electives.add(subject);
            totalCredits += subject.getCredit();
        }
    }
    
    public int getTotalCredit() {
        return totalCredits;
    }
    
    public boolean isEnrolled(Subject subject) {
        boolean alreadyEnrolled = false;
        
        // Check if the elective is already enrolled in
        for(Subject sub : electives) {
            if(sub.isSame(subject))
                alreadyEnrolled = true;
        }
        
        // ...Also check it isn't a core subject
        for(Subject sub : cores) {
            if(sub.isSame(subject))
                alreadyEnrolled = true;
        }
        
        // ...And not in the major
        if(major.isIncluded(subject))
            alreadyEnrolled = true;
        
        return alreadyEnrolled;
    }
    
    public String toString() {
        String result = student.toString() + "\n\n";
        
        result += "Cores:\n";
        for(Subject sub : cores)
        {
            result += sub + "\n";
        }
        
        result += "\nMajor: " + major + "\n";
        
        result += "Electives:\n";
        for(Subject sub : electives)
        {
            result += sub + "\n";
        }
        result += "-----------------\n";
        result += "Total Enrolled Credit Points: " + totalCredits + "pt";

        return result;
    }
    
}

class Student {
    private String name, gender, dob;
    private int number;
    
    public Student() {
        this("", "", "", 0);
    }
    
    public Student(String name, String gender, String dob, int number) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.number = number;
    }
    
    public String toString() {
        return "Student: " + name + " (" + number + ", " + gender + ", " + dob + ")";
    }
}

class Course {
    private String name;
    private int credit;
    private ArrayList<Subject> cores;
    private ArrayList<Major> majors;
    private ArrayList<Subject> electives;
    
    public Course() {
        this("");
    }
    
    public Course(String name) {
        this.name = name;
        cores = new ArrayList<Subject>();
        majors = new ArrayList<Major>();
        electives = new ArrayList<Subject>();
    }
    
    public void addCores(Subject[] subjects) {
        // Note: alternate way to loop over an array
        // for(int i = 0; i < subjects.length; i++) {
        //     cores.add(subjects[i]);
        // }
        for(Subject sub : subjects) {
            cores.add(sub);
        }
    }
    
    public void addMajors(Major[] majors) {
        for(Major major : majors) {
            this.majors.add(major);
        }
    }
    
    public void addElectives(Subject[] electives) {
        for(Subject sub : electives) {
            this.electives.add(sub);
        }
    }
    
    public ArrayList<Subject> getCores() {
        return cores;
    }
    
    public ArrayList<Subject> getElectives() {
        return electives;
    }
    
    public String toString() {
        String result = "Welcome to enrol the Bachelor of " + name + " course.\n";
        result += "The course structure is as follows:\n";
        result += "-----------------\n";
        result += "Course: " + name + "\n\nCore Subjects:\n";
        for(Subject sub : cores) {
            result += sub + "\n";
        }
        result += "\n";
        
        for(Major major : majors) {
            result += major + "\n";
        }
        
        result += "Elective Subjects:\n";
        for(Subject sub : electives) {
            result += sub + "\n";
        }
        
        return result;
    }
    
    public String getName() {
        return name;
    }
    
    public ArrayList<Major> getMajors() {
        return majors;
    }
    
    public int getCredit() {
        return credit;
    }
}

class Major {
    private String name;
    private ArrayList<Subject> subjects;
    
    public Major() {
        this("");
    }
    
    public Major(String name) {
        this.name = name;
        subjects = new ArrayList<Subject>();
    }
    
    public void addCores(Subject[] cores) {
        for(Subject sub : cores) {
            subjects.add(sub);
        }
    }
    
    public ArrayList<Subject> getCores() {
        return subjects;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isIncluded(Subject subject) {
        for(Subject sub : subjects) {
            // Takeaway: It is important to use the isSame() method as we will have deep copies of subjects in the next lab
            if(sub.isSame(subject))
                return true;
        }
        return false;
    }
    
    public String toString() {
        String result = name + "\n";
        
        for(Subject sub : subjects) {
            result += sub + "\n";
        }
       
        return result;
    }
}

class Subject {
    private String name, code;
    private int credit;
    
    public Subject() {
        this("", "", 0);
    }
    
    public Subject(String code, String name, int credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
    }
    
    public int getCredit() {
        return credit;
    }
    
    public String getCode() {
        return code;
    }
    
    public boolean isSame(Subject subject) {
        return (subject == this || subject.getCode().equals(this.code));
    }
    
    public String toString() {
        return code + " (" + name + ", " + credit + "pt)";
    }
}
