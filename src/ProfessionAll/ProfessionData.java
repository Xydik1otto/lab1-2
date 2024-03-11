package ProfessionAll;

public class ProfessionData {
    private String name;
    private String description;

    public ProfessionData(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}