import java.util.*;

/**
 * Created by Zehra Yılmaz on 26.12.2016.
 */
public class Graph {
    private HashMap<String, Room> rooms;
    private HashMap<Integer, Edge> edges;

    public Graph(){
        this.rooms = new HashMap<>();
        this.edges = new HashMap<>();
    }

    /**
     * This constructor accepts an ArrayList<Room> and populates
     * this.rooms. If multiple Room objects have the same label,
     * then the last Room with the given label is used.
     *
     * @param rooms The initial Rooms to populate this Graph
     */
    public Graph(ArrayList<Room> rooms){
        this.rooms = new HashMap<String, Room>();
        this.edges = new HashMap<Integer, Edge>();

        for(Room r: rooms){
            this.rooms.put(r.getLabel(), r);
        }

    }

    /**
     * This method adds am edge between Rooms one and two
     * of weight 1, if no Edge between these Rooms already
     * exists in the Graph.
     *
     * @param one The first room to add
     * @param two The second room to add
     * @return true iff no Edge relating one and two exists in the Graph
     */
    public boolean addEdge(Room one,Room two){
        return addEdge(one, two, 1);
    }


    /**
     * Accepts two rooms and a weight, and adds the edge
     * ({one, two}, weight) if no Edge relating one and two
     * exists in the Graph.
     *
     * @param one The first Room of the Edge
     * @param two The second Room of the Edge
     * @param weight The weight of the Edge
     * @return true iff no Edge already exists in the Graph
     */
    public boolean addEdge(Room one, Room two, int weight){
        if(one.equals(two)){
            return false;
        }

        //ensures the Edge is not in the Graph
        Edge e = new Edge(one, two, weight);
        if(edges.containsKey(e.hashCode())){
            return false;
        }

        //and that the Edge isn't already incident to one of the rooms
        else if(one.containsNeighbor(e) || two.containsNeighbor(e)){
            return false;
        }

        edges.put(e.hashCode(), e);
        one.addNeighbor(e);
        two.addNeighbor(e);
        return true;
    }

    /**
     *
     * @param e The Edge to look up
     * @return true if this Graph contains the Edge e
     */
    public boolean containsEdge(Edge e){
        if(e.getOne() == null || e.getTwo() == null){
            return false;
        }

        return this.edges.containsKey(e.hashCode());
    }


    /**
     * This method removes the specified Edge from the Graph,
     * including as each room's incidence neighborhood.
     *
     * @param e The Edge to remove from the Graph
     * @return Edge The Edge removed from the Graph
     */
    public Edge removeEdge(Edge e){
        e.getOne().removeNeighbor(e);
        e.getTwo().removeNeighbor(e);
        return this.edges.remove(e.hashCode());
    }

    /**
     *
     * @param room The Room to look up
     * @return true if this Graph contains room
     */
    public boolean containsRoom(Room room){
        return this.rooms.get(room.getLabel()) != null;
    }

    /**
     *
     * @param label The specified Room label
     * @return Room The Room with the specified label
     */
    public Room getRoom(String label){
        return rooms.get(label);
    }

    /**
     * This method adds a Room to the graph. If a Room with the same label
     * as the parameter exists in the Graph, the existing Room is overwritten
     * only if overwriteExisting is true. If the existing Room is overwritten,
     * the Edges incident to it are all removed from the Graph.
     *
     * @param room
     * @param overwriteExisting
     * @return true iff room was added to the Graph
     */
    public boolean addRoom(Room room, boolean overwriteExisting){
        Room current = this.rooms.get(room.getLabel());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }

            while(current.getNeighborCount() > 0){
                this.removeEdge(current.getNeighbor(0));
            }
        }


        rooms.put(room.getLabel(), room);
        return true;
    }

    /**
     *
     * @param label The label of the Room to remove
     * @return Room The removed Room object
     */
    public Room removeRoom(String label){
        Room r = rooms.remove(label);

        while(r.getNeighborCount() > 0){
            this.removeEdge(r.getNeighbor((0)));
        }

        return r;
    }

    /**
     *
     * @return Set<String> The unique labels of the Graph's Room objects
     */
    public Set<String> roomKeys(){
        return this.rooms.keySet();
    }

    /**
     *
     * @return Set<Edge> The Edges of this graph
     */
    public Set<Edge> getEdges(){
        return new HashSet<Edge>(this.edges.values());
    }

}
