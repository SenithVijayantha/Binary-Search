import java.util.Scanner;

public class OrderAgnosticBSImproved {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the integer you want to search for: ");
        int target = in.nextInt();
        in.close();

        int[] arr = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int ans = orderAgnosticBinarySearch(arr, target);
        if (ans == -1) {
            System.out.println("Target not found");
        } else {
            System.out.println("Target element is at index " + ans);
            System.out.println("arr[ans] = " + arr[ans]);
        }
    }

    static int orderAgnosticBinarySearch(int[] arr, int target) {

        // will return -1 if the target was not found 

        int start = 0;
        int end = arr.length - 1;

        // find whether the array is sorted in ascending or descending 
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            // int mid = (start + end) / 2 - Might be possible that (start + end) exceeds the range of int in Java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}
