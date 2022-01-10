package demos.week2;

import java.util.Random;
import java.util.Scanner;

public class Sphere {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getVolume() {
        return (4.0/3.0) * Math.PI * radius * radius * radius;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.print("enter radius: ");
//
//        Sphere s = new Sphere(in.nextDouble());
//
//        System.out.printf("volume: %.2f\n", s.getVolume());
//        in.close();
        int n1 = (int) (Math.random() * 100) + 1;
        int n2 = (int) (Math.random() * 100) + 1;
        int n3 = (int) (Math.random() * 100) + 1;
        double avg = (n1+n2+n3) / 3.0;

        System.out.println("Random number 1: " + n1);
        System.out.println("Random number 2: " + n2);
        System.out.println("Random number 3: " + n3);
        System.out.println("Average: " + avg);

        String str = "Candy";

        System.out.println(str.substring(str.length()/2-1, str.length()/2+2));


    }
}
