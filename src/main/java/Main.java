public class Main {
    public static void main(String[] args) {
        Point a = new Point(2, 1);
        Point b = new Point(4, 1);
        Point c = new Point(2, 4);

        Triangle triangle = new Triangle(a, b, c);
        System.out.println(triangle.isRectangular());
    }
}
