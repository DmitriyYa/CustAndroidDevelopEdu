import java.util.Objects;

public class LineSegment {
    private Point onePoint;
    private Point twoPoint;

    private double longLineSigment;

    public LineSegment(final Point onePoint, final Point twoPoint) {
        Objects.requireNonNull(onePoint);
        Objects.requireNonNull(twoPoint);
        this.onePoint = onePoint;
        this.twoPoint = twoPoint;
        this.longLineSigment = constructSegmentTwoPoints(onePoint, twoPoint);
    }

    public double getLongLineSigment() {
        return longLineSigment;
    }


    /**
     * построить отрезок по двум точкам
     * @param a
     * @param b
     * @return
     */
    private double constructSegmentTwoPoints(final Point a, final Point b) {
        double result;
        double powResult = Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2);
        result = Math.sqrt(powResult);
        return result;
    }
}
