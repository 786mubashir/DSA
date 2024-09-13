import java.io.*;
import java.util.*;

class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Array obj = new Array();
        obj.array();
        ArrayList<Integer> arr1 = obj.ArrayList();
        int n = arr1.size();
        System.out.print("Which number you want to search : ");
        int Ele = scanner.nextInt();
        obj.BinaryRecursion(arr1, 0, n, Ele);
        int []arr = {1,2,3,5,6,4,2,5,2};
        int numofEleInArray = obj.removeElement(arr,2);

    }

    // Array
    public void array() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
        System.out.println("Array");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + "    ");
        }
        System.out.println("");
    }

    // Array List
    public ArrayList<Integer> ArrayList() {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        for (int i = 10; i < 20; i++) {
            arr1.add(i);
        }
        System.out.println("Array List");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr1.get(i) + "    ");
        }
        System.out.println("");
        return arr1;
    }

    // Binary search in array list
    public int BinaryRecursion(ArrayList<Integer> arr1, int Start, int End, int Ele) {
        if (Start > End) {
            System.out.println("The number " + Ele + " is not found");
            return -1;
        }

        int mid = Start + (End - Start) / 2; // Correct calculation of mid

        if (arr1.get(mid) == Ele) {
            System.out.println("The number " + Ele + " is at index " + mid);
            return mid;
        } else if (arr1.get(mid) < Ele) {
            return BinaryRecursion(arr1, mid + 1, End, Ele); // Search in the right half
        } else {
            return BinaryRecursion(arr1, Start, mid - 1, Ele); // Search in the left half
        }
    }

    // Remove Element from the array
    public int removeElement(int[] arr, int val) {
        int size = arr.length - 1;
        int i = 0;

        while (i <= size) {
            if (arr[i] == val) {
                // Swap with the last element
                arr[i] = arr[size];
                size--; // Reduce the size of the array to consider
            } else {
                i++; // Only move to the next element if no swap occurred
            }
        }
        return size + 1; // Return the new size of the array
    }

}