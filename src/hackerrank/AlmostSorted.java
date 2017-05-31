package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class AlmostSorted {

    private static void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void reverse(int arr[], int index1, int index2) {
        for (int i=index1; i<=(index1 + index2)/2; i++) {
            swap(arr, i, index2--);
        }
    }

    private static boolean isSorted(int arr[], int size) {
        for (int i=0; i<size-1; i++) {
            if(arr[i]>arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    private static void almostSort(int[] arr, int size) {
        int index1=0, index2=0;
        boolean swap = false;
        for (int i=0; i < size-1; i++) {
            if (arr[i] > arr[i+1]) {
                index1 = i;
                break;
            }
        }
        for (int i=size-1; i>0; i--) {
            if (arr[i] < arr[i-1]) {
                index2 = i;
                break;
            }
        }
        if (index2-index1 == 0) {
            System.out.println("yes");
            return;
        }
        if((index2-index1) <= 2 || arr[index1+1] < arr[index1+2]) {
            swap = true;
        }
        if (swap) {
            swap(arr, index1, index2);
        } else {
            reverse(arr, index1, index2);
        }

        if(isSorted(arr, size)) {
            System.out.println("yes");
            if(swap) {
                System.out.println("swap " + (index1+1) + " " + (index2+1));
            } else {
                System.out.println("reverse " + (index1+1) + " " + (index2+1));
            }
        } else {
            System.out.println("no");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        almostSort(arr, size);
    }
}
