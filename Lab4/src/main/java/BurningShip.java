import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator {

    public static final int MAX_ITERATIONS = 2000;

    public void getInitialRange(Rectangle2D.Double range) {
        range.setRect(-2, -2.5, 4, 4);
    }

    public int numIterations(double x, double y) {
        MandelbrotFractal.ComplexNumber z = new MandelbrotFractal.ComplexNumber(0d, 0d);
        MandelbrotFractal.ComplexNumber c = new MandelbrotFractal.ComplexNumber(x, y);
        MandelbrotFractal.ComplexNumber a = new MandelbrotFractal.ComplexNumber(0, 0);
        for (int i = 1; i <= MAX_ITERATIONS; i++) {
            if (z.getSquaredModulus() > 4) {
                return i;
            }
            //double k = r * r - i * i + x;
            //double m = Math.abs(2 * r * i) + y;
            z = new MandelbrotFractal.ComplexNumber(z.getRealPart()* z.getRealPart()-z.getImaginPart()*z.getImaginPart()+c.getRealPart(),Math.abs(2*z.getRealPart()*z.getImaginPart())+c.getImaginPart());
        }
        return -1;
    }
    public String toString(){return "BurningShip";}
}
