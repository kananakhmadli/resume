package main;

import util.*;

public class Main {

    public static void main(String[] args) {
        boolean b = true;
        System.out.println("register");
        while (b) {

            int menu = InputUtil.requireNumber("What do you want to do"
                    + "\n1.Registr student"
                    + "\n2.Show all students"
                    + "\n3.Find a tudent"
                    + "\n4.Update student"
                    + "\n5.Exit"
                    + "\n6.Exit(additional)");

            if (menu == 1) {
                StudentUtil.registerStudents();

            } else if (menu == 2) {
                StudentUtil.printAllRegisteredStudents();

            } else if (menu == 3) {
                StudentUtil.findStudents();

            } else if (menu == 4) {
                StudentUtil.updateStudent();

            } else if (menu == 5) {
                b = false;

            } else if (menu == 6) {
                System.exit(0); 
            }
        }
    }
}
