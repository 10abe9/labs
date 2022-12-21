public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null && obj.getClass() != this.getClass())
            return false;

        Location location = (Location) obj;
        return xCoord == location.xCoord && yCoord == location.yCoord;
    }
    public int hashCode() {
        int result = 17; // Простое число
        result = 37 * result + xCoord;
        result = 37 * result + yCoord;
        return result;
    }
}