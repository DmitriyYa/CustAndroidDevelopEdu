import java.util.Arrays;

public class Triangle {

    private Point onePoint;
    private Point twoPoint;
    private Point threePoint;

    public Triangle(Point onePoint, Point twoPoint, Point threePoint) {
        if (allPointsLieDifferentPlanes(onePoint, twoPoint, threePoint)) {
            if (twoOrThreeVerticesNotOnePoint(onePoint, twoPoint, threePoint)) {
                this.onePoint = onePoint;
                this.twoPoint = twoPoint;
                this.threePoint = threePoint;
            }
        } else {
            System.out.println("Заданы не верные координаты");
        }
    }

    // проверить треугольник на прямой угол
    public boolean isRectangular() {
        boolean flag = false;
        double a = constructSegmentTwoPoints(this.onePoint, this.twoPoint);
        double b = constructSegmentTwoPoints(this.twoPoint, this.threePoint);
        double c = constructSegmentTwoPoints(this.threePoint, this.onePoint);
        double[] array = sortAscending(a, b, c);
        if (Math.round(Math.pow(array[2], 2)) == Math.round(Math.pow(array[1], 2) + Math.pow(array[0], 2))) {
            flag = true;
        }
        return flag;
    }

    //    построить отрезок по двум точкам
    private double constructSegmentTwoPoints(Point a, Point b) {
        double result;
        double powResult = Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2);
        result = Math.sqrt(powResult);
        return result;
    }

    //    Все точки теругольника лежат в разной плоскости
    private boolean allPointsLieDifferentPlanes(Point a, Point b, Point c) {
        boolean result = false;
        if (a.getX() != b.getX() || b.getX() != c.getX()) {
            if (a.getY() != b.getY() || b.getY() != c.getY()) {
                result = true;
            }
        }
        return result;
    }

    //    две или все три вершины не лежат в одной точке.
    private boolean twoOrThreeVerticesNotOnePoint(Point a, Point b, Point c) {
        boolean result = false;
        if (!a.equals(b) && !a.equals(c)) {
            if (!b.equals(c)) {
                result = true;
            }
        }
        return result;
    }

    // сортировать по возрастанию
    private double[] sortAscending(double a, double b, double c) {
        double[] result = new double[3];
        result[0] = a;
        result[1] = b;
        result[2] = c;
        Arrays.sort(result);
        return result;
    }
}