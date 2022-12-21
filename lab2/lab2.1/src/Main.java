import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Point3D p1 = newPoint3D(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble());
        System.out.println("2nd point: ");
        Point3D p2 = newPoint3D(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble());
        double distance = distanceTo(p1,p2);

        System.out.println("distance is: "+distance);
        scanner.close();
    }
    public static Point3D newPoint3D(double x,double y,double z)
    {
        Point3D point = new Point3D(x,y,z);
        return point;
    }

    private static double distanceTo(Point3D p1, Point3D p2)
    {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double z1 = p1.getZ();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double z2 = p2.getZ();
        double x0 = Math.abs(x2-x1) ;
        double y0 = Math.abs(y2-y1) ;
        double z0 = Math.abs(z2-z1);
        double dist = Math.pow( Math.pow(x0,2) + Math.pow(y0,2) + Math.pow(z0,2), 0.5);
        return dist;
    }
}