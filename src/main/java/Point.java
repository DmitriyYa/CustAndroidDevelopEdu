public class Point {

    private int x;
    private int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * определить расстояние до точки
     * @param b
     * @return
     */
    public double getDistanceToPoint(final Point b) {
        double result;
        double powResult = Math.pow(this.getX() - b.getX(), 2) + Math.pow(this.getY() - b.getY(), 2);
        result = Math.sqrt(powResult);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
