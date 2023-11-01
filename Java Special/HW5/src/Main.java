/*
 * Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
 * Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5, отсортированных по убыванию среднего балла.
 * В решении не использовать циклы! Только StreamAPI
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(new Student("Михаил", "Информатика", 5,4,3,5,4,2,5,4,4,3,3,2));
        listStudent.add(new Student("Анастатия", "Математика", 4,2,3,1,4,3,5,4,3,4,1,4));
        listStudent.add(new Student("Евгений", "Информатика", 5,4,5,5,5,5,5,4,5,3,5,5));
        listStudent.add(new Student("Анастатия", "Информатика", 4,5,5,4,4,5,2,4,5,4,5,4));
        listStudent.add(new Student("Поддельников", "Информатика", 5,5,5,5,5,5,5,4,5,4,5,5));


        listStudent.stream()
                .filter(student -> student.getSpecialty().equals("Информатика"))
                .filter(student -> student.getAverageGrade() > 4.5)
                //.sorted((student1, student2) -> (int) (student1.getAverageGrade() - student2.getAverageGrade()))
                .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())
                .limit(5)
                .forEach(student -> System.out.println(student.getName() + " " + student.getAverageGrade()));
    }
}