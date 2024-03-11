import EmployeeData.EmployeeData;
import ProfessionAll.ProfessionData;
import ProfessionAll.Professions;
import ProfessionAll.Professions.PositionData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<EmployeeData> EMPLOYEES = new ArrayList<>();
    private static final List<PositionData> POSITIONS = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMain Menu:");
            System.out.println("1. View Positions");
            System.out.println("2. View Employees");
            System.out.println("3. Assign Employee to Position");
            System.out.println("4. Dismiss Employee from Position");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = SCANNER.nextInt();
            SCANNER.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    displayPositions();
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    assignEmployeeToPosition();
                    break;
                case 4:
                    dismissEmployeeFromPosition();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeData() {
        EmployeeData employee1 = new EmployeeData("John", "Doe");
        EmployeeData employee2 = new EmployeeData("Jane", "Doe");
        EMPLOYEES.add(employee1);
        EMPLOYEES.add(employee2);

        ProfessionData programming = new ProfessionData("Programmer", "Performs programming tasks");
        ProfessionData sysAdmin = new ProfessionData("System Administrator", "Performs system administration tasks");


        PositionData programmerPosition = new PositionData("Programmer", "Performs programming tasks");
        PositionData sysAdminPosition = new PositionData("System Administrator", "Performs system administration tasks");

        programmerPosition.addRequiredProfession(programming);
        sysAdminPosition.addRequiredProfession(sysAdmin);

        POSITIONS.add(programmerPosition);
        POSITIONS.add(sysAdminPosition);
    }

    private static void displayPositions() {
        System.out.println("\nList of Positions:");
        for (PositionData position : POSITIONS) {
            position.displayInfo();
            System.out.println();
        }
    }

    private static void displayEmployees() {
        System.out.println("\nList of Employees:");
        for (EmployeeData employee : EMPLOYEES) {
            employee.displayInfo();
            System.out.println();
        }
    }

    private static void assignEmployeeToPosition() {
        System.out.println("\nAssign Employee to Position:");
        displayEmployees();
        System.out.print("Enter employee number: ");
        int empNumber = SCANNER.nextInt() - 1;
        SCANNER.nextLine(); // Clear buffer

        if (empNumber >= 0 && empNumber < EMPLOYEES.size()) {
            EmployeeData employee = EMPLOYEES.get(empNumber);
            displayPositions();
            System.out.print("Enter position number: ");
            int posNumber = SCANNER.nextInt() - 1;
            SCANNER.nextLine(); // Clear buffer

            if (posNumber >= 0 && posNumber < POSITIONS.size()) {
                PositionData position = POSITIONS.get(posNumber);
                if (position.isQualified(employee)) {
                    System.out.println(employee.getFirstName() + " " + employee.getLastName() + " has been assigned to " + position.getClass());
                } else {
                    System.out.println("Employee does not have the required professions for this position.");
                }
            } else {
                System.out.println("Invalid position number.");
            }
        } else {
            System.out.println("Invalid employee number.");
        }
    }

    private static void dismissEmployeeFromPosition() {
        System.out.println("\nDismiss Employee from Position:");
        displayEmployees();
        System.out.print("Enter employee number: ");
        int empNumber = SCANNER.nextInt() - 1;
        SCANNER.nextLine(); // Clear buffer

        if (empNumber >= 0 && empNumber < EMPLOYEES.size()) {
            EmployeeData employee = EMPLOYEES.get(empNumber);
            System.out.println(employee.getFirstName() + " " + employee.getLastName() + " has been dismissed from their position.");
        } else {
            System.out.println("Invalid employee number.");
        }
    }
}
