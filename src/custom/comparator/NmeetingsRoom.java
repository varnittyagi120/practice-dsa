package src.custom.comparator;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NmeetingsRoom {
    public static void main(String[] args) {
        List<Integer> arrayListOne = new ArrayList<>();
        List<Integer> arrayListTwo = new ArrayList<>();
        arrayListOne.add(1);
        arrayListOne.add(3);
        arrayListOne.add(0);
        arrayListOne.add(5);
        arrayListOne.add(8);

        arrayListTwo.add(2);
        arrayListTwo.add(4);
        arrayListTwo.add(6);
        arrayListTwo.add(7);
        arrayListTwo.add(9);

        List<Meetings> meetingsList = new ArrayList<>();
        for (int i=0;i<arrayListOne.size();i++){
            Meetings meetings = new Meetings(arrayListOne.get(i), arrayListTwo.get(i));
            meetingsList.add(meetings);
        }
        MeetingComparator meetingComparator = new MeetingComparator();
        Collections.sort(meetingsList, meetingComparator);
        int count = 1;
        int end = meetingsList.get(0).end;
        for(int i=1;i<meetingsList.size();i++){
            if(end<meetingsList.get(i).start){
                count++;
                end = meetingsList.get(i).end;
            }
        }
        System.out.println(count);
    }
}
