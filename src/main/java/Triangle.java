import java.util.Arrays;
import java.util.Objects;

public class Triangle {

    private Point onePoint;
    private Point twoPoint;
    private Point threePoint;

    public Triangle(Point onePoint, Point twoPoint, Point threePoint) {
        Objects.requireNonNull(onePoint);
        Objects.requireNonNull(twoPoint);
        Objects.requireNonNull(threePoint);
        if (allPointsLieDifferentPlanes(onePoint, twoPoint, threePoint)) {
            if (twoOrThreeVerticesNotOnePoint(onePoint, twoPoint, threePoint)) {
                this.onePoint = onePoint;
                this.twoPoint = twoPoint;
                this.threePoint = threePoint;
            }
        } else {
             throw new IllegalArgumentException("Не верный аргумент");
        }
    }

    /**
     * проверить треугольник на прямой угол
     * @return
     */
    public boolean isRectangular() {
        boolean flag = false;
        final double a = new LineSegment(this.onePoint,this.twoPoint).getLongLineSigment();
        final double b = new LineSegment(this.twoPoint,this.threePoint).getLongLineSigment();
        final double c = new LineSegment(this.threePoint,this.onePoint).getLongLineSigment();
        final double[] array = sortAscending(a, b, c);
        if (Math.round(Math.pow(array[2], 2)) == Math.round(Math.pow(array[1], 2) + Math.pow(array[0], 2))) {
            flag = true;
        }
        return flag;
    }

    /**
     * Все точки теругольника лежат в разной плоскости
     * @param a
     * @param b
     * @param c
     * @return
     */
    private boolean allPointsLieDifferentPlanes(final Point a, final Point b, final Point c) {
        boolean result = false;
        if (a.getX() != b.getX() || b.getX() != c.getX()) {
            if (a.getY() != b.getY() || b.getY() != c.getY()) {
                result = true;
            }
        }
        return result;
    }

    /**
     * две или все три вершины не лежат в одной точке.
     * @param a
     * @param b
     * @param c
     * @return
     */
    private boolean twoOrThreeVerticesNotOnePoint(final Point a, final Point b, final Point c) {
        boolean result = false;
        if (!a.equals(b) && !a.equals(c)) {
            if (!b.equals(c)) {
                result = true;
            }
        }
        return result;
    }


    /**
     * сортировать по возрастанию
     * @param a
     * @param b
     * @param c
     * @return
     */
    private double[] sortAscending(final double a, final double b, final double c) {
        double[] result = new double[3];
        result[0] = a;
        result[1] = b;
        result[2] = c;
        Arrays.sort(result);
        return result;
    }
}