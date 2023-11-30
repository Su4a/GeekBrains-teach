package Lesson2.two;

public class Main {
    public interface MouseListener {
        void mouseUp();
        void mouseDown();
    }

    //Вложенный класс
    private static class MouseAdapter implements MouseListener {
        @Override public void mouseUp() {}
        @Override public void mouseDown() {}
    }

    private static void addMouseListener(MouseListener l) {
        l.mouseDown();
        l.mouseUp();
    }

    public static void main(String[] args) {
        //Создание вложенного класса и передача его в интерфейс
        MouseAdapter m = new MouseAdapter();
        addMouseListener(m);

        //Сразу создание вложенного класса с использованием интерфейса
        addMouseListener(new MouseAdapter());

        //Создание интерфейса без вложенного класса и переопределение его методов
        MouseListener l = new MouseListener() {
            @Override public void mouseUp() {

            }
            @Override public void mouseDown() {

            }
        };
        addMouseListener(l);

        //Создание анонимного класса сразу с добавлением его к интерфейсу с переопределением методов, которые реализуют слушателя
        addMouseListener(new MouseListener() {
            @Override public void mouseUp() {

            }
            @Override public void mouseDown() {

            }
        });

    }

}
