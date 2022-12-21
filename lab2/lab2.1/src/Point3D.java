import java.util.Scanner;

public class Point3D extends Point2D
{
    private double zCoord;
    public Point3D(double x ,double y, double z)
    {
        super(x, y);
        zCoord = z;
    }
    public Point3D(){this(0,0, 0);}
    public double getZ()
    {
        return zCoord;
    }

    public void setZ(double val)
    {
        zCoord = val;
    }
    private double distanceTo(Point3D p1, Point3D p2)
    {
        double x1 = getX();
        double y1 = getY();
        double z1 = getZ();
        double x2 = getX();
        double y2 = getY();
        double z2 = getZ();
        p1 = new Point3D (x1, y1, z1);
        p2 = new Point3D (x2, y2, z2);
        double x0 = Math.abs(x2-x1) ;
        double y0 = Math.abs(y2-y1) ;
        double z0 = Math.abs(z2-z1);
        double dist = Math.pow( Math.pow(x0,2) + Math.pow(y0,2) + Math.pow(z0,2), -2);
        return dist;
    }
}
