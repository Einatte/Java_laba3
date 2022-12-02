import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static Timer AddTimer(ArrayList<Integer> list_arr, LinkedList<Integer> list_link, int quantity) {
        long start;
        Timer result = new Timer();
        start = System.currentTimeMillis();
        for (int i = 0; i < quantity; i++)
            list_arr.add(0);
        result.setT_array(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < quantity; i++)
            list_link.add(0);
        result.setT_link(System.currentTimeMillis() - start);

        return result;
    }

    public static Timer SortTimer(ArrayList<Integer> list_arr, LinkedList<Integer> list_link, int quantity) {
        long start;
        Timer result = new Timer();

        start = System.currentTimeMillis();
        for (int i = 0; i < quantity; i++)
            Collections.sort(list_arr);
        result.setT_array(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < quantity; i++)
            Collections.sort(list_link);
        result.setT_link(System.currentTimeMillis() - start);

        return result;
    }

    public static Timer GetTimer(ArrayList<Integer> list_arr, LinkedList<Integer> list_link, int quantity) {
        long start;
        Object temp;
        Timer result = new Timer();

        start = System.currentTimeMillis();
        for (int i = 0; i < quantity; i++)
            temp = list_arr.get(i);
        result.setT_array(System.currentTimeMillis()- start);

        start = System.currentTimeMillis();
        for (int i = 0; i <quantity; i++)
            temp = list_link.get(i);
        result.setT_link(System.currentTimeMillis() - start);
        return result;
    }

    public static Timer DeletionTimer(ArrayList<Integer> list_arr, LinkedList<Integer> list_link, int quantity) {
        long start; int i;
        Timer result = new Timer();

        start = System.currentTimeMillis();
        for (i = quantity - 1; i >= 0; i--)
            list_arr.remove(i);
        result.setT_array(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (i = quantity - 1; i >= 0; i--)
            list_link.remove(i);
        result.setT_link(System.currentTimeMillis() - start);

        return result;
    }


    public static void print(Timer result_add, Timer result_get, Timer result_delete, Timer result_sort, int quantity) {
        System.out.printf ("%-10s%-10s%-10s%n", "Method" + "\t\t\t\t\t", "Repetitions" + "\t\t\t", "Time");

        System.out.printf("%-20s", "LinkedList: add");
        System.out.printf("%20s", quantity);
        System.out.printf("%20s", result_add.getT_link());
        System.out.println();
        System.out.printf("%-20s", "ArrayList: add");
        System.out.printf("%20s", quantity);
        System.out.printf("%20s", result_add.getT_array());
        System.out.println();
        System.out.printf("%-20s", "LinkedList:get");
        System.out.printf("%20s", quantity);
        System.out.printf("%20s", result_get.getT_link());
        System.out.println();
        System.out.printf("%-20s", "ArrayList: get");
        System.out.printf("%20s", quantity);
        System.out.printf("%20s", result_get.getT_array());
        System.out.println();
        System.out.printf("%-20s", "LinkedList: delete");
        System.out.printf("%20s", quantity);
        System.out.printf("%20s", result_delete.getT_link());
        System.out.println();
        System.out.printf("%-20s", "ArrayList: delete");
        System.out.printf("%20s", quantity);
        System.out.printf("%20s", result_delete.getT_array());
        System.out.println();
        System.out.printf("%-20s", "LinkedList: sort");
        System.out.printf("%20s",quantity);
        System.out.printf("%20s", result_sort.getT_link());
        System.out.println();
        System.out.printf("%-20s", "ArrayList: sort");
        System.out.printf("%20s", quantity);
        System.out.printf("%20s", result_sort.getT_array());
        System.out.println();

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <Integer> list_arr = new ArrayList<>();
        LinkedList <Integer> list_link = new LinkedList<>();
        int quantity;

        System.out.println ("Enter the number of repetitions:");
        quantity = in.nextInt();

        Timer result_add;
        result_add = AddTimer (list_arr, list_link, quantity);

        Timer result_get;
        result_get = GetTimer (list_arr, list_link, quantity);

        Timer result_sort;
        result_sort = SortTimer (list_arr, list_link, quantity);

        Timer result_delete;
        result_delete = DeletionTimer (list_arr, list_link, quantity);

        print (result_add, result_get, result_delete,result_sort, quantity);
    }
}
