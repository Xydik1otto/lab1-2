package EmployeeData;


import ProfessionAll.ProfessionData;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    private String firstName;
    private String lastName;
    private List<ProfessionData> professions;

    public EmployeeData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.professions = new ArrayList<>();
    }

    public void addProfession(ProfessionData profession) {
        professions.add(profession);
    }

    public void removeProfession(ProfessionData profession) {
        professions.remove(profession);
    }

    public void displayInfo() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Professions:");
        for (ProfessionData profession : professions) {
            System.out.println("- " + profession.getName());
        }
    }

    public void performTasks() {
        System.out.print(firstName + " " + lastName + " performs tasks ");
        for (ProfessionData profession : professions) {
            System.out.print(profession.getDescription() + " ");
        }
        System.out.println();
    }

    public List<ProfessionData> getProfessions() {
        return professions;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}