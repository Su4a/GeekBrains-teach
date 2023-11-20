import java.util.Arrays;
import java.util.List;

public class Student {
    private final String name;
    private final List<Double> grades;
    private final String specialty;

    public Student(String name, String specialty, double... arr) {
        this.name = name;
        this.specialty = specialty;
        this.grades = Arrays.stream(arr).boxed().toList();
    }

    public double getAverageGrade() {
        return grades.stream()
                .mapToDouble(e -> e)
                .average()
                .getAsDouble();
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }


}
