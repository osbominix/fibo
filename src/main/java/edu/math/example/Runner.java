package edu.math.example;

/**
 * Created by yl on 13.08.17.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by yl on 13.08.17.
 */
public class Runner {

    public static void main(String[] args) {
        MyFibo myFibo = MyFibo.getInstance();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Please enter index of fibo:  ");

            try {
                int index = scanner.nextInt();
                int myFiboNr = myFibo.getFiboByIndex(index);
                if (myFiboNr > 0) {
                    System.out.println("the Fibo nummer of index " + index + " is: " + myFiboNr);
                }
            } catch (InputMismatchException exception) {
                System.out.println("Please give an integer number.");
            }
        }
    }
}
