public class Main {
    public static void main(String[] args) {
        Personal[] personal = new Personal[5];
        personal[0] = new Personal("Пупкин", "Василий", "Олегович", 22, "Дровосек", "drovosek.pro@gmail.com", "+79114045289", "161999");
        personal[1] = new Personal("Миклух", "Алексей", "Мухович", 47, "Тестер снов", "mir.grez@gmail.com", "+79110045281", "45000");
        personal[2] = new Personal("Фомин", "Антон", "Станиславович", 22, "Бонус Хантер", "necbitochnie.mechti@gmail.com", "+79314245088", "0");
        personal[3] = new Personal("Эльбрус", "Магомед", "Аджарашманд", 35, "Смотрящий подъемник", "beckonechno.vverh@gmail.com", "+79124443281", "220555");
        personal[4] = new Personal("Эродаровограз", "Пропан", "Бутанович", 42, "Коллектор", "denegvglaz@gmail.com", "+79114065220", "26111");

        for (Personal i : personal) {
            if (i.getAge() > 40) i.doToString();
        }
    }
}
