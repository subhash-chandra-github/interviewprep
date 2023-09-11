package com.interviewprep.backtracking;

import java.util.Arrays;

public class TestPiramal {


    public static void main(String[] args) {

        int[] trucks = new int[] {29, 25};
        int[] boxes = new int[] {10,2,16,19};

        System.out.println(getMinTime(trucks,boxes));
    }

    public static int getMinTime(int[] trucks, int[] boxes) {
        Arrays.sort(trucks);
        Arrays.sort(boxes);

        int maxCap = trucks[trucks.length - 1];

        int maxBox = boxes[boxes.length - 1];

        if (maxBox > maxCap) {
            return -1;
        }
        int l = 0;
        int h = boxes.length * 8;
        int minTime = 0;
        while (l <= h) {
            int mid = (h + l) / 2;
            if (possibleInTime(trucks, boxes, mid)) {
                minTime = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return minTime;
    }

   public static boolean possibleInTime(int[] trucks, int[] boxes, int minTime)  // 7,6,5,4,3  [3,4,5,6,7] (
                                                                                         //  [3,10]
    {

        int time = 0;
        int c = 0;
        int j = 0;
        int capacity = 0;
        while (c < boxes.length && j < trucks.length) {

            if (capacity <= trucks[j]) {
                while(capacity<=trucks[j]) {
                    capacity = capacity + boxes[c];
                    c++;
                }
                }
            else{
                c--;
                    if (c == boxes.length - 1) {
                        time = time + 1;
                    }else {
                        time = time + 8;
                    }
                    capacity=0;
                    j++;
                }

        }
        return time < minTime;

    }

}
