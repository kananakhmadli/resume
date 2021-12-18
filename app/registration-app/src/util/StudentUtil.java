package util;

import beans.Student;
import main.Database;

public class StudentUtil {

    public static Student fillStudent() {

        String name = InputUtil.requireText("Enter a name");

        String surname = InputUtil.requireText("Enter a surname");

        int age = InputUtil.requireNumber("Enter a age");

        String className = InputUtil.requireText("Enter the class");

        Student st = new Student(name, surname, age, className);
        return st;
    }

    public static void printAllRegisteredStudents() {
        if (Database.students == null) {
            return;
        }
        for (int i = 0; i < Database.students.length; i++) {
            Student st = Database.students[i];
            System.out.println((i + 1) + "." + st.getFullInfo());
        }
    }

    public static void registerStudents() {
        int count = InputUtil.requireNumber("How many students you will register?");

        Database.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((1 + i) + "-------------------------Register--------------------------");

            Database.students[i] = StudentUtil.fillStudent();
        }
        System.out.println("Restration was completed successfully");
        StudentUtil.printAllRegisteredStudents();

    }

    public static void findStudents() {
        String text = InputUtil.requireText("Typ name ,surname or class name");
        for (int i = 0; i < Database.students.length; i++) {
            Student st = Database.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                System.out.println(st.getFullInfo());
            }
        }
    }

    public static void updateStudent() {
        StudentUtil.printAllRegisteredStudents();
        int index = InputUtil.requireNumber("Enter the index");
        Student s = StudentUtil.fillStudent();
        Database.students[index - 1] = s;
    }

    public static void updateStudentTwo() {
        int index = InputUtil.requireNumber("Enter the index");
        Student s = Database.students[index - 1];
        String outs = InputUtil.requireText("What do you want to change:Exp name,surname,age,class");
        String arr[] = outs.split(",");
        for (int i = 0; i < arr.length; i++) {

            if (arr[i].equalsIgnoreCase("name")) {
                s.setName(InputUtil.requireText("Enter name"));

            } else if (arr[i].equalsIgnoreCase("surname")) {
                s.setSurname(InputUtil.requireText("Enter surname"));

            } else if (arr[i].equalsIgnoreCase("age")) {
                s.setAge(InputUtil.requireNumber("Enter age"));

            } else if (arr[i].equalsIgnoreCase("class")) {
                s.setClassName(InputUtil.requireText("Enter class"));
            }
        }
    }
}
