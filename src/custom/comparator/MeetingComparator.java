package src.custom.comparator;

import java.util.Comparator;

public class MeetingComparator implements Comparator<Meetings> {

    @Override
    public int compare(Meetings o1, Meetings o2) {
        return o1.end>o2.end ? 1 : -1;
    }
}
