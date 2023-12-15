public class Employee {
    private String name;
    private String telephoneNumber;
    private String personnelNumber;
    private String experience;

    public Employee(String name, String telephoneNumber, String personnelNumber, String experience) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.personnelNumber = personnelNumber;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getPersonnelNumber() {
        return personnelNumber;
    }

    public String getExperience() {
        return experience;
    }
}
