package com.interviewprep.dsa.bSearch;

public class FindFirstOccurrence {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 3, 4, 5, 6};
        System.out.println("Binary Search " + binarySearch(arr, 0, arr.length - 1, 3));
        System.out.println("First Occurrence " + firstOccurrence(arr, 0, arr.length - 1, 3));
        System.out.println("Last Occurrence " + lastOccurrence(arr, 0, arr.length - 1, 3));
        System.out.println("Strictly Decreasing Element" + strictlyDecreasing(arr, 0, arr.length - 1, 3));
        System.out.println("Strictly Increasing Element" + strictlyIncreasing(arr, 0, arr.length - 1, 3));
    }



    static int binarySearch(int[] arr, int low, int high, int target) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                ans = mid;
                return ans;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }


    static int firstOccurrence(int[] arr, int low, int high, int target) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static int lastOccurrence(int[] arr, int low, int high, int target) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static int strictlyDecreasing(int[] arr, int low, int high, int target) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static int strictlyIncreasing(int[] arr, int low, int high, int target) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;

            }
        }
        return ans;
    }
}
