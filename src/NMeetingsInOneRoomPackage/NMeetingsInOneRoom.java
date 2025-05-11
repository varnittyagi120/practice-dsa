package src.NMeetingsInOneRoomPackage;

public class NMeetingsInOneRoom {
    /*
     //{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Meeting{
    int start;
    int end;
    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }

}

class MeetingComparator implements Comparator<Meeting>{
    @Override
    public int compare(Meeting o1, Meeting o2){
        return o1.end>o2.end?1:-1;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        List<Meeting> meetingList = new ArrayList<>();
        for(int i=0;i<n;i++){
            Meeting meeting = new Meeting(start[i], end[i]);
            meetingList.add(meeting);
        }
        MeetingComparator meetingComparator = new MeetingComparator();
        Collections.sort(meetingList, meetingComparator);
        int count = 1;
        int globalEnd = meetingList.get(0).end;
        for(int i=1;i<n;i++){
            if(globalEnd<meetingList.get(i).start){
                count++;
                globalEnd = meetingList.get(i).end;
            }
        }
        return count;
    }
}
     */
}
