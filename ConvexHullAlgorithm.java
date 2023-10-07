import java.util.*;

public class ConvexHullAlgorithm {
    public static List<int[]> findConvexHull(int[][] points) {
        if (points.length < 3) {
            return Arrays.asList(points);
        }

        Arrays.sort(points,
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<int[]> upperHull = new ArrayList<>();
        List<int[]> lowerHull = new ArrayList<>();

        for (int[] point : points) {
            while (upperHull.size() >= 2 && isCounterClockwise(
                    upperHull.get(upperHull.size() - 2),
                    upperHull.get(upperHull.size() - 1),
                    point)) {
                upperHull.remove(upperHull.size() - 1);
            }
            upperHull.add(point);
        }

        for (int i = points.length - 1; i >= 0; i--) {
            int[] point = points[i];
            while (lowerHull.size() >= 2 && isCounterClockwise(
                    lowerHull.get(lowerHull.size() - 2),
                    lowerHull.get(lowerHull.size() - 1),
                    point)) {
                lowerHull.remove(lowerHull.size() - 1);
            }
            lowerHull.add(point);
        }

        HashSet<int[]> convexHullSet = new HashSet<>(upperHull);
        convexHullSet.addAll(lowerHull);
        return new ArrayList<>(convexHullSet);
    }

    private static boolean isCounterClockwise(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]) <= 0;
    }

    public static void main(String[] args) {
        
        final long startTime = System.nanoTime();
        int[][] points = { { 0, 0 }, { 2, -3 }, { -2, -1 },
  { -3, 2 }, { 1, 1 }, { 4, -4 },
  { -4, -2 }, { -1, 2 }, { 2, 3 },
  { 3, -1 }, { -5, -5 }, { 5, 5 },
  { 6, -2 }, { -6, 3 }, { 7, 4 },
  { -7, -7 }, { 8, -3 }, { -8, 6 },
  { 9, 2 }, { 10, -4 }, { -9, -8 },
  { -10, 7 }, { 11, 1 }, { 12, 5 },
  { -11, -6 }, { 13, -5 } };
        List<int[]> hull = findConvexHull(points);

        System.out.println("Convex Hull:");
        for (int[] point : hull) {
            System.out.println(point[0] + " " + point[1]);
            
        }
        final long endTime = System.nanoTime();

        System.out.println("Total execution time: " + (endTime - startTime));

    }
}
