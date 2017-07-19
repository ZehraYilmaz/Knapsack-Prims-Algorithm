/**
 * Created by Zehra Yılmaz on 26.12.2016.
 */
public class Edge {
    private Room one, two;
    private int weight;

    public Edge(Room one, Room two){
        this(one,two,1);
    }
    public Edge(Room one, Room two, int weight){

        this.one = (one.getLabel().compareTo(two.getLabel()) <= 0) ? one : two;
        this.two = (this.one == one) ? two : one;
        this.weight = weight;
    }
    public Room getNeighbor(Room current){
        if(!(current.equals(one) || current.equals(two))){
            return null;
        }
        return (current.equals(one)) ? two : one;
    }
    public Room getOne(){

        return this.one;

    }

    public Room getTwo(){
        return this.two;
    }

    public int getWeight(){
        return this.weight;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }

    public int compareTo(Edge other){
        return this.weight - other.weight;
    }
    public boolean equals(Object other){
        if(!(other instanceof Edge)){
            return false;
        }
        Edge e = (Edge)other;
        return e.one.equals(this.one) && e.two.equals(this.two);
    }
}



