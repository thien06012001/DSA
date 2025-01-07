package Week6.Lecture;

import java.util.ArrayList;
import java.util.List;

public class BruteForceConvexHull {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    // Function to determine the convex hull
    public static List<Point> convexHull(Point[] points) {
        int n = points.length;
        List<Point> hull = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                boolean allOnOneSide = true;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j)
                        continue;

                    // Check which side of the line P_iP_j the point P_k lies on
                    int side = orientation(points[i], points[j], points[k]);

                    // If points are not all on one side, break
                    if (side > 0) { // On one side
                        allOnOneSide = false;
                        break;
                    }
                }

                // If all points are on one side, (Pi, Pj) is part of the convex hull
                if (allOnOneSide) {
                    if (!hull.contains(points[i])) {
                        hull.add(points[i]);
                    }
                    if (!hull.contains(points[j])) {
                        hull.add(points[j]);
                    }
                }
            }
        }

        return hull;
    }

    // Helper function to compute orientation
    // Returns 0 if collinear, >0 if clockwise, <0 if counterclockwise
    public static int orientation(Point p1, Point p2, Point p3) {
        return (p2.y - p1.y) * (p3.x - p2.x) - (p2.x - p1.x) * (p3.y - p2.y);
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 0),
                new Point(0, 3),
                new Point(3, 3)
        };

        List<Point> hull = convexHull(points);

        System.out.println("Convex Hull:");
        for (Point p : hull) {
            System.out.println(p);
        }
    }
}
