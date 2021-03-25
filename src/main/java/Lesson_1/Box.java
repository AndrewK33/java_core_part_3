package Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Box<N> {

    Orange orange = new Orange();
    Apple apple = new Apple();

    private float boxWeight = 0.0f;
    private List<N> box;


    public Box(N... items) {
        this.box = new ArrayList<>(Arrays.asList(items));
    }


    public float getWeight() {
        float fruitWeight = 0.0f;
        if (box.get(0).getClass().equals(orange.getClass())) {
            fruitWeight = orange.getWeight();
        } else fruitWeight = apple.getWeight();

        boxWeight = fruitWeight * box.size();

        return boxWeight;
    }




    public void addToBox(N n) {
        box.add(n);
    }





    public void whatsInTheBox () {
        System.out.println(box.toString());
    }

    public double sum() {
        double res = 0.0;
        return res;
    }


    public boolean compareByWeight (Box<?> anotherBox1) {
        return this.getWeight() == anotherBox1.getWeight();
        //return Math.abs(this.sum() - anotherBox1.sum()) < 0.0001;
    }




    public <T> void  transferToBox (Box<N> anotherBox2) {
        anotherBox2.box.addAll(this.box);
        this.box.clear();
    }


}
