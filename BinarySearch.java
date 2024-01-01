import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the integer you want to search for: ");
        int target = in.nextInt();
        in.close();
        
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        
        int ans = BinarySearchAlgo(arr, target);
        System.out.println("Target element is at index " + ans);
        System.out.println("arr[ans] = " + arr[ans]);
    }

    static int BinarySearchAlgo(int[] arr, int target) {

        // will return -1 if the target was not found 

        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            // int mid = (start + end) / 2 - Might be possible that (start + end) exceeds the range of int in Java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
