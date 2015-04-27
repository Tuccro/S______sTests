import java.util.Scanner;

public class Main {

//    This program sorts points array by
//    X-coordinates and if they are the same
//    sorts this intervals by Y

    public static void main(String[] args) {

        Point[] points;

//        points = new Point[]{new Point(1, 1), new Point(4, 2),
//                new Point(0, 4), new Point(0, 2),
//                new Point(1, 5), new Point(8, 8),
//                new Point(1, 4), new Point(8, 7)};

        points = dataInput();

        sortPointsByX(points);
        deepSort(points);

        for (Point p : points) {
            System.out.println(p.getX() + " " + p.getY());
        }

    }

    public static Point[] dataInput() {
        int number;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number of points:");
        number = in.nextInt();

        Point[] points = new Point[number];
        int x, y;

        for (int k = 0; k < number; k++) {
            System.out.println("Enter X: ");
            x = in.nextInt();

            System.out.println("Enter Y: ");
            y = in.nextInt();

            points[k] = new Point(x, y);
        }
        // println for beauty
        System.out.println();
        return points;
    }

    // Sort by X-coordinates
    public static void sortPointsByX(Point[] points) {
        Point point;
        int min;
        for (int k = 0; k < points.length - 1; k++) {
            point = points[k];
            min = k;

            for (int p = k + 1; p < points.length; p++) {
                if (points[p].getX() < points[min].getX()) {
                    min = p;
                }
            }
            if (!(min == k)) {
                points[k] = points[min];
                points[min] = point;
            }
        }
    }

    // Detecting points where same X-coordinates and sort it
    public static void deepSort(Point[] points) {

        for (int k = 0; k < points.length - 1; k++) {

            if (points[k].getX() == points[k + 1].getX()) {
                // Detecting a part of array where same X-coordinates
                int begin = k;
                int end = begin + 1;

                // Refine interval of points array
                for (int p = end; p < points.length; p++) {
                    if (points[begin].getX() == points[p].getX()) {
                        end = p;
                        k = p;
                    }
                }
                sortPointsByY(points, begin, end);
            }
        }
    }

    // Sort by Y-coordinates by array interval
    public static void sortPointsByY(Point[] points, int begin, int end) {
        Point point;
        int min;
        for (int k = begin; k < end; k++) {
            point = points[k];
            min = k;

            for (int p = k + 1; p < end+1; p++) {
                if (points[p].getY() < points[min].getY()) {
                    min = p;
                }
            }
            if (!(min == k)) {
                points[k] = points[min];
                points[min] = point;
            }
        }
    }
}
