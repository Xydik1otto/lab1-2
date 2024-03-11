package ProfessionAll;

import EmployeeData.EmployeeData;

import java.util.ArrayList;
import java.util.List;

public class Professions {
    public static class PositionData {
        private String name;
        private String description;
        private List<ProfessionData> requiredProfessions;

        public PositionData(String name, String description) {
            this.name = name;
            this.description = description;
            this.requiredProfessions = new ArrayList<>();
        }

        public void addRequiredProfession(ProfessionData profession) {
            requiredProfessions.add(profession);
        }

        public void displayInfo() {
            System.out.println("Position Name: " + name);
            System.out.println("Description: " + description);
            System.out.println("Required Professions:");
            for (ProfessionData profession : requiredProfessions) {
                System.out.println("- " + profession.getName());
            }
        }

        public boolean isQualified(EmployeeData employee) {
            for (ProfessionData profession : requiredProfessions) {
                boolean hasProfession = false;
                for (ProfessionData empProfession : employee.getProfessions()) {
                    if (empProfession.getName().equals(profession.getName())) {
                        hasProfession = true;
                        break;
                    }
                }
                if (!hasProfession) {
                    return false;
                }
            }
            return true;
        }
    }
}
