package src;

import java.util.PriorityQueue;

//time complexity : O(nlog(k))
// space complexity : O(K)
public class KClosestPointsToOrigin {

    class Coordinate {
        int[] coordinate;
        double distance;

        public Coordinate(int[] coordinate, double distance) {
            this.coordinate = coordinate;
            this.distance = distance;
        }

        public double getDistance() {
            return distance;
        }

        public int[] getCoordinate() {
            return coordinate;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        //max heap
        PriorityQueue<Coordinate> queue = new PriorityQueue<>((a, b) -> (Double.compare(b.getDistance(), a.getDistance())));
        for (int i = 0; i < points.length; i++) {
            double sum = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            double distance = Math.sqrt(sum);
            Coordinate coordinate = new Coordinate(points[i], distance);
            queue.add(coordinate);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            result[i] = coordinate.getCoordinate();
            i++;
        }
        return result;
    }
}
