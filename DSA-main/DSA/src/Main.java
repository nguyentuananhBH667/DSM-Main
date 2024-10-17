import Models.Student;

import java.io.FileNotFoundException;
import java.util.*;
import Sort.ISort;
import Search.ISearch;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students");
        String n = sc.next();
        try{
            int length = Integer.parseInt(n);
        } catch (NumberFormatException e) {
            System.out.println("Not a number, enter a number");
            n = sc.next();
        }
        Student[] students = new Student[Integer.parseInt(n)];

        option(students);
        // 1,2,3,4,5,6,7,8,9
    }
    static void option(Student[] students) {
        System.out.print("Let choose the following options: ");
        System.out.print("1) add Student. ");
        System.out.print("2) edit Student. ");
        System.out.print("3) delete Student. ");
        System.out.print("4) display Student. ");
        System.out.print("5) search Student. ");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        switch(s) {
            case "1": {
                System.out.println("1) Enter student 's information to add");
                add(students);
                break;
            }
            case "2": edit(students);
            case "3": {
                remove(students);
                break;
            }
            case "4": {

                System.out.println("Choose your option:");
                System.out.print("1) Order by Id. ");
                System.out.print("2) Order by Name. ");
                System.out.print("3) Order by Mark. ");
                String order = sc.next();
                display(students, order);
                break;
            }
            case "5": search(students);

        }
    }
    static void add(Student[] students) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < students.length;i++) {
            System.out.print("Enter student id: ");
            String id = sc.next();
            try{
                int newId = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID");
                add(students);
            }
            sc.nextLine();
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter student score: ");
            String score = sc.nextLine();
            try{
                double newScore = Double.parseDouble(score);
            } catch (NumberFormatException e) {
                System.out.println("Invalid score");
            }
            if(students[0] != null) {
                for(int j = 0; j < students.length;j++) {
                    if(students[j] != null && students[j].getId() == Integer.parseInt(id)) {
                        System.out.println("This id already exists, please enter another id");
                        i = 0;
                    }
                }
            }
            if(students[i] == null) {
                students[i] = new Student(Integer.parseInt(id), name,Double.parseDouble(score));
                students[i].setRank();
                System.out.println("Added student " + id + " with name " + name + " and score " + score);
            }
        }
        printArray(students);
        System.out.println("'back': Back to main menu. ");
        System.out.println("'display': Display Students. ");
        String option = sc.nextLine();
        insideOption(students,option);
    }
    static void edit(Student[] students) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student id: ");
        String id = sc.next();
        ISearch search = new Search();
        try{
            int findId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Id");
            edit(students);
        }
        sc.nextLine();
        int index = search.searchById(students,id);
        if(index == -1) {
            System.out.println("Student not found");
            edit(students);
        }
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student score: ");
        String score = sc.nextLine();

        try{
            double newMark = Double.parseDouble(score);
        } catch (NumberFormatException e) {
            System.out.println("Invalid mark");
            edit(students);
        }
        students[index].setName(name);
        students[index].setMark(Double.parseDouble(score));
        printArray(students);
        System.out.println("'back': Back to main menu. ");
        System.out.println("'display': Display Students. ");
        String option = sc.nextLine();
        insideOption(students,option);
    }
    static void display(Student[] students, String order) {
        Scanner sc = new Scanner(System.in);
        ISort sort = new Sort();
        switch(order) {
            case "1": {
                Student[] result = sort.sortById(students, 0, students.length - 1);
                printArray(result);
                System.out.println("'back': Back to main menu. ");
                System.out.println("'display': Display Students. ");
                String option = sc.nextLine();
                insideOption(students,option);
                break;
            }
            case "2": {
                Student[] result = sort.sortByName(students, 0, students.length - 1);
                printArray(result);
                System.out.println("'back': Back to main menu. ");
                System.out.println("'display': Display Students. ");
                String option = sc.nextLine();
                insideOption(students,option);
                break;
            }
            case "3": {
                Student[] result = sort.sortByMark(students, 0, students.length - 1);
                printArray(result);
                System.out.println("'back': Back to main menu. ");
                System.out.println("'display': Display Students. ");
                String option = sc.nextLine();
                insideOption(students,option);
                break;
            }
        }
    }

    static void printArray(Student[] students) {
        int n = students.length;
        for(int i = 0; i < n; ++i){
            System.out.println("Student Id: "+ students[i].getId());
            System.out.println("Student Name: " + students[i].getName());
            System.out.println("Student Mark: " + students[i].getMark());
            System.out.println("Student Rank: " + students[i].getRank());
        }
        System.out.println();
    }
    public static void search(Student[] students) {
        Scanner sc = new Scanner(System.in);
        ISearch search = new Search();
        System.out.println("Enter your option: ");
        System.out.println("Search by Id");
        System.out.println("Search by Name");
        String order = sc.nextLine();

        switch(order) {
            case "1": {
                System.out.print("Enter student id: ");
                String x = sc.next();
                sc.nextLine();
                int index = search.searchById(students,x);
                System.out.println("Student Id: "  + students[index].getId());
                System.out.println("Student name: " + students[index].getName());
                System.out.println("Student mark: " + students[index].getMark());
                System.out.println("Student Rank: " + students[index].getRank());
                System.out.println("'back': Back to main menu. ");
                System.out.println("'display': Display Students. ");
                String option = sc.nextLine();
                insideOption(students,option);
                break;
            }
            case "2": {
                System.out.print("Enter student name: ");
                String x = sc.nextLine();
                Student[] result = search.searchByName(students, x);
                printArray(result);
                System.out.println("'back': Back to main menu. ");
                System.out.println("'display': Display Students. ");
                String option = sc.nextLine();
                insideOption(students,option);
                break;
            }
        }
    }
    public static void remove(Student[] students) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student id: ");
        String id = sc.next();
        try{
            int findId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Id");
        }
        sc.nextLine();
        Student[] newStudents = new Student[students.length - 1];
        ISearch search = new Search();
        int index = search.searchById(students,id);
        for(int i = 0,k = 0; i < students.length;i++) {
            if(i != index) {
                newStudents[k] = students[i];
                k++;
            }
        }
        printArray(newStudents);
        System.out.println("'back': Back to main menu. ");
        System.out.println("'display': Display Students. ");
        String option = sc.nextLine();
        insideOption(newStudents,option);
    }
    static void insideOption(Student[] students, String option) {
        switch (option) {
            case "display": printArray(students);
            case "back" : option(students);
        }
    }
}