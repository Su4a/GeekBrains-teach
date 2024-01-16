package org.example;
//Есть пять философов (потоки), которые могут либо обедать либо размышлять.
//Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
//После каждого приема пищи философ должен размышлять
//Не должно возникнуть общей блокировки
//Философы не должны есть больше одного раза подряд


import java.util.concurrent.Semaphore;

//Настройте проект с использованием сборщика проектов Maven или Gradle.
//В проекте должны быть зависимости от сторонних библиотек, а также минимальные настройки сборки (например, указание версии Java, настройка плагинов).
public class Main {

    public static void main(String[] args) {
        int countFilosov = 5;
        Semaphore sem = new Semaphore (countFilosov);
        for (int i = 0; i < countFilosov; i++) {
            new Thread(new Filosov(i, sem)).start();
        }
    }
}