import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestIsRectangular {
    Point a;
    Point b;
    Point c;
    Triangle triangle;

    @Test
    public void isRectangularTrue() {
        a = new Point(2, 1);
        b = new Point(4, 1);
        c = new Point(2, 4);
        triangle = new Triangle(a, b, c);
        assertTrue(triangle.isRectangular());
    }

    @Test
    public void isRectangularFalse(){
        a = new Point(-2, 1);
        b = new Point(4, 1);
        c = new Point(3, 4);
        triangle = new Triangle(a, b, c);
        assertFalse(triangle.isRectangular());
    }

    @Test(expected = IllegalArgumentException.class)
    public void allPointsInOneLine() {
        a = new Point(2, 1);
        b = new Point(2, 3);
        c = new Point(2, 4);
        triangle = new Triangle(a, b, c);
        triangle.isRectangular();
    }

    @Test(expected = IllegalArgumentException.class)
    public void somePointsEqualce() {
        a = new Point(2, 1);
        b = new Point(2, 1);
        c = new Point(2, 4);
        triangle = new Triangle(a, b, c);
        triangle.isRectangular();
    }
}
