class Personal {
    private String family;
    private String name;
    private String patronymic;
    private String position;
    private String email;
    private String numberPhone;
    private String salary;
    private int age;

    Personal(String family, String name, String patronymic, int age, String position, String email, String numberPhone, String salary) {
        this.family = family;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.numberPhone = numberPhone;
        this.salary = salary;
        this.age = age;
    }

    int getAge() {
        return age;
    }

    void doToString() {
        System.out.println(family + " | " + name + " | " + patronymic + " | " + age + " | " + position + " | " + email + " | " + numberPhone + " | " + salary);
    }
}
