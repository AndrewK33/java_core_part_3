package Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //Задание 1
        String[] arr = {"A", "B", "C", "D"};

        System.out.println(Arrays.toString(arr));
        swapElements(arr, 0, 3);
        System.out.println(Arrays.toString(arr));



        //Задание 2 преобразование массива в ArrayList
        String[] arrayOfStrings = {"Apple", "Bob", "Box"};
        List<String> listOfStrings = new ArrayList<String>();
        Collections.addAll(listOfStrings, arrayOfStrings);




        //Задание 3 Манипуляции с коробками и фруктами
        //Создание объектов и наполнение бокса
        Orange orange = new Orange();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Apple apple = new Apple();

        Box<Orange> orangeBox = new Box<>(orange1, orange, orange2);
        Box<Apple> appleBox = new Box<>(apple, new Apple());

        orangeBox.addToBox(new Orange());

        //Вывод информации по весу бокса
        System.out.println("Вес коробки с апельсинами равен: " + orangeBox.getWeight());
        System.out.println("Вес коробки с яблоками равен: " + appleBox.getWeight());

        //Сравнение бокса по весу.... внутри также написал сравнение и по модулю
        System.out.println(orangeBox.compareByWeight(appleBox));

        //Трансфинг объектов между боксами
        Box<Apple> appleBox1 = new Box<>();
        appleBox.transferToBox(appleBox1);
        appleBox.whatsInTheBox();
        appleBox1.whatsInTheBox();

    }


    private static <T> void swapElements(T[] array, int index1, int index2) {
        T tempVar = array[index1];
        array[index1] = array[index2];
        array[index2] = tempVar;
    }


}
