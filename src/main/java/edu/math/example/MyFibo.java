package edu.math.example;

/**
 * Created by yl on 13.08.17.
 */
import java.util.LinkedList;

/**
 * Created by yl on 13.08.17.
 */
public class MyFibo {

    private static MyFibo instance;
    private LinkedList<Integer> fiboLinkedList = new LinkedList<Integer>();
    private int fiboLastIndex;
    private static final int FIBO_NOT_EXISTS = -1;

    private MyFibo() {
        initFiboLinkedList();
    }

    private void initFiboLinkedList() {
        fiboLinkedList.add(1);
        fiboLinkedList.add(1);
        int tmp;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            fiboLastIndex = fiboLinkedList.size() - 1;
            tmp = fiboLinkedList.get(fiboLastIndex) + fiboLinkedList.get(fiboLastIndex - 1);
            //tmp will be negative if INTEGER.MAX_VALUE is exceeded.
            if (tmp > 0) {
                fiboLinkedList.add(tmp);
            } else {
                break;
            }
        }
    }

    public static MyFibo getInstance() {
        if (instance == null) {
            instance = new MyFibo();
        }
        return instance;
    }

    public int getFiboByIndex(int userGivenIndex) {
        try {
            //index in arrayList is begin with 0, but for user it begins with 1.
            int userAllowedIndex = fiboLastIndex + 1;
            if ((userGivenIndex < 1) || (userGivenIndex > userAllowedIndex) ) {
                throw new Exception("Please give an index between 1 and " + userAllowedIndex);
            }
            return fiboLinkedList.get(userGivenIndex - 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return FIBO_NOT_EXISTS;
        }

    }

}

