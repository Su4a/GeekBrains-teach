import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Comparable<Employee> {
    protected int salary;
    protected static int salaryAll = 0;
    protected String date;

    public Employee() {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        date = formatForDateNow.format(new Date());
        salary = 0;
    }

    protected void addSalary(int salary) {
        this.salary += salary;
    }

    public String getDate() {
        return date;
    }

    public int getSalary() {
        return salary + salaryAll;
    }

    @Override
    public int compareTo(Employee employee) {
        if (this.date.equals(employee.getDate())) return 1;
        return 0;
    }
}
