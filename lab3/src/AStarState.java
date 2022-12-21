import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ForkJoinWorkerThread;

public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private final Map2D map;
    private final HashMap<Location,Waypoint>openWaypoints =new HashMap<>();
    private final HashMap<Location, Waypoint> closeWaypoints = new HashMap<>();
    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }


    public int numOpenWaypoints()
    {
        return openWaypoints.size();
    }

    public Waypoint getMinOpenWaypoint() {
        if (numOpenWaypoints() == 0) {
            return null;
        }
        Waypoint minWaypoint = null;
        float min = Float.MAX_VALUE;

        for (Waypoint waypoint : openWaypoints.values()) {
            float cost = waypoint.getTotalCost();
            if (cost < min) {
                min = cost;
                minWaypoint = waypoint;
            }
        }
        return minWaypoint;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public void addOpenWaypoint(Waypoint newWP)
    {
        Waypoint openWP = openWaypoints.get(newWP.loc);
        if(openWP == null || newWP.getPreviousCost()<openWP.getPreviousCost()){
            openWaypoints.put(newWP.loc,newWP);
        }
    }
    /** Returns the current number of open waypoints. **/

    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public boolean isLocationClosed(Location loc)
    {
        return closeWaypoints.containsKey(loc);
    }
    public void closeWaypoint(Location loc)
    {
        Waypoint waypoint = openWaypoints.remove(loc);
        closeWaypoints.put(loc,waypoint);
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/

}
