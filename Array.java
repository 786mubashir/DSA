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
        System.out.print("Enter Size of Array : ");
        int k = scanner.nextInt();
        int nums[] =new int[k];
        for(int i = 0 ; i < k ; i++){
            System.out.print("Enter Ele of Array : ");
            nums[i] = scanner.nextInt();
        }
        obj.PrintRecuPermute(nums);
        // the merge sorting is starting
        System.out.println();
        System.out.println("Merge Sort is started.");
        int [] mergeArr = obj.Array(7);
       mergeArr = obj.MergeSort(mergeArr, 0, 7);
        for(int i = 0 ; i < 7 ; i++){
            System.out.print(mergeArr[i] + "    ");
        }
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

    public HashSet<Integer> allPermutation(int[]arr , int n,int c){
        HashSet<Integer> res = new HashSet();
        return res;
    }

    //Get all the possible permutation
      // Get all possible permutations using recursion and backtracking
      public void RecuPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));  // Add a new copy of ds to ans
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                ds.add(nums[i]);
                freq[i] = true;  // Mark this number as used
                RecuPermute(nums, ds, ans, freq);
                ds.remove(ds.size() - 1);  // Backtrack
                freq[i] = false;  // Reset the frequency
            }
        }
    }

    // Print all permutations
    public void PrintRecuPermute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        RecuPermute(nums, ds, ans, freq);

        // Print each permutation
        for (List<Integer> perm : ans) {
            for (int num : perm) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // this function is use to make an arr and return arr;
    public int[] Array(int n ){
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            System.out.print("Enter number : ");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    // Merger Sort Algorithm           
    public int[] MergeSort(int arr[] , int low , int high){
        if (low >= high) return arr;

        int mid = (low + high) / 2;
    
        // Sort the first half
        MergeSort(arr, low, mid);
        // Sort the second half
        MergeSort(arr, mid + 1, 6);
        // Merge the sorted halves
        Merge(arr, low, mid, 6);
    return arr;
    }


    //this function is use to merge the for mergeSort
    public void Merge(int arr[], int low, int mid, int high) {
        int left = low;      // Pointer for left half (low to mid)
        int right = mid + 1; // Pointer for right half (mid+1 to high)
    
        // Temporary array to store merged result
        int[] temp = new int[high - low + 1];
        int index = 0;
    
        // Traverse both halves and store the smaller element into temp[]
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }
    
        // If there are remaining elements in the left half, add them to temp[]
        while (left <= mid) {
            temp[index] = arr[left];
            left++;
            index++;
        }
    
        // If there are remaining elements in the right half, add them to temp[]
        while (right <= high) {
            temp[index] = arr[right];
            right++;
            index++;
        }
    
        // Copy the sorted elements back into the original array
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }
    
}