package practice;

import java.util.ArrayList;
import java.util.List;

public class StreamSize {

    List<StreamLog> logs;
    int now = -1;                                   // FIX 1: track latest timestamp

    public StreamSize() {
        this.logs = new ArrayList<>();
    }

    public void add(int timestamp, int sizeBytes) {
        now = timestamp;                            // FIX 1: update now on every add
        if (logs.isEmpty()) {
            logs.add(new StreamLog(timestamp, sizeBytes, sizeBytes));
        } else {
            StreamLog prev = logs.get(logs.size() - 1);
            logs.add(new StreamLog(timestamp, sizeBytes, prev.sumTillHere + sizeBytes));
        }
    }

    public int getTotalSize(int lastNSeconds) {
        if (logs.isEmpty()) return 0;

        int cutoff = now - lastNSeconds;            // FIX 1: use tracked now, not hardcoded
        int pivot  = bSearch(logs, cutoff);         // first index where timestamp > cutoff

        if (pivot >= logs.size()) return 0;

        int total  = logs.get(logs.size() - 1).sumTillHere;
        int before = (pivot == 0) ? 0 : logs.get(pivot - 1).sumTillHere; // FIX 4: guard idx-1
        return total - before;                      // FIX 3: range sum, not adjacent diff
    }

    // Returns first index where timestamp > cutoff
    private int bSearch(List<StreamLog> stream, int cutoff) {
        int lo = 0, hi = stream.size() - 1, pivot = stream.size();
        while (lo <= hi) {
            int mid = (lo + hi) /2;
            if (stream.get(mid).timestamp > cutoff) {
                pivot = mid;
                hi = mid - 1;                      // FIX 2: go left to find earlier match
            } else {
                lo = mid + 1;                      // FIX 2: go right (was backwards)
            }
        }
        return pivot;
    }

    public static void main(String[] args) {
        StreamSize stream = new StreamSize();

        stream.add(1000, 1);
        stream.add(1001, 2);
        stream.add(1002, 5);
        stream.add(1003, 6);
        stream.add(1003, 8);
        stream.add(1006, 10);

        // now = 1006, cutoff for N=3 → 1003
        // entries with ts > 1003: only [1006,10] → expect 10
        System.out.println(stream.getTotalSize(3));  // 10

        // cutoff for N=7 → 999 → all entries → expect 32
        System.out.println(stream.getTotalSize(7));  // 32

        // cutoff for N=1 → 1005 → only [1006,10] → expect 10
        System.out.println(stream.getTotalSize(1));  // 10

        // cutoff for N=4 → 1002 → ts > 1002: [1003,6],[1003,8],[1006,10] → expect 24
        System.out.println(stream.getTotalSize(4));  // 24
    }
}