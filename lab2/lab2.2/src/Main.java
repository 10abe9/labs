import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Point3d p1 = new Point3d(scan.nextDouble(),scan.nextDouble(),scan.nextDouble());
        Point3d p2 = new Point3d(scan.nextDouble(),scan.nextDouble(),scan.nextDouble());
        Point3d p3 = new Point3d(scan.nextDouble(),scan.nextDouble(),scan.nextDouble());
        if (IsntIdent(p1,p2,p3)){
            System.out.print(computeArea(p1,p2,p3));}
        else {System.out.print("Точки совпадают. это не треугольник");}
        scan.close();
    }
    public static boolean IsntIdent(Point3d p1,Point3d p2, Point3d p3)
    {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double z1 = p1.getZ();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double z2 = p2.getZ();
        double x3 = p3.getX();
        double y3 = p3.getY();
        double z3 = p3.getZ();
        if (x1-x2==0 & y1-y2==0 &z1-z2==0){return false;}
        if (x1-x3==0 & y1-y3==0 & z1-z3==0){return false;}
        if (x2-x3==0 & y2-y3==0 & z2-z3==0){return false;}
        else{return true;}
    }
    public static double computeArea(Point3d p1,Point3d p2,Point3d p3)
    {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double z1 = p1.getZ();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double z2 = p2.getZ();
        double x3 = p3.getX();
        double y3 = p3.getY();
        double z3 = p3.getZ();
        double AB = Math.pow( Math.pow(x1-x2,2)+Math.pow(z1-z2,2)+Math.pow(y1-y2,2) ,0.5) ;
        double BC = Math.pow( Math.pow(x2-x3,2)+Math.pow(z2-z3,2)+Math.pow(y2-y3,2),0.5);
        double AC = Math.pow( Math.pow(x1-x3,2)+Math.pow(z1-z3,2)+Math.pow(y1-y3,2),0.5) ;
        double P = (AB+AC+BC)/2 ;
        double res = Math.pow(((P-AB)*(P-AC)*(P-BC))*P,0.5);
        return res;
    }
}
