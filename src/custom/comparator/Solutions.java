package src.custom.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solutions {
    public static void main(String[] args) {
        List<Meetings> list = new ArrayList<>();
        Meetings meetings1 = new Meetings(1,2);
        list.add(meetings1);
        Meetings meetings2 = new Meetings(3,4);
        list.add(meetings2);
        Meetings meetings3 = new Meetings(0,6);
        list.add(meetings3);
        Meetings meetings4 = new Meetings(5,7);
        list.add(meetings4);
        Meetings meetings5 = new Meetings(8,9);
        list.add(meetings5);
        MeetingComparator meetingComparator = new MeetingComparator();
        Collections.sort(list, meetingComparator);
        for (Meetings meetings : list) {
            System.out.println(meetings.start+" "+meetings.end);
        }
    }
}
