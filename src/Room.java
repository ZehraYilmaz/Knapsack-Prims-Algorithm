import java.util.ArrayList;

/**
 * Created by Zehra Yılmaz on 26.12.2016.
 */
public class Room {
    private ArrayList<Edge> neighborhood;
   // BST books = new BST();
    private String label;
    private int key;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }





    public Room(String label,int key) {
        this.label = label;
        this.key = key;
        this.neighborhood = new ArrayList<>();

    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void addNeighbor(Edge edge){
        if(this.neighborhood.contains(edge)){
            return;
        }

        this.neighborhood.add(edge);
    }
    public Edge getNeighbor(int index) {
        return this.neighborhood.get(index);
    }
    Edge removeNeighbor(int index){

        return this.neighborhood.remove(index);
    }
    public void removeNeighbor(Edge e){
        this.neighborhood.remove(e);
    }
    public int getNeighborCount(){
        return this.neighborhood.size();
    }
    public boolean equals(Object other){

        if(!(other instanceof Room)){

            return false;
        }

        Room r = (Room)other;
        return this.label.equals(r.label);
    }

    public ArrayList<Edge> getNeighbors(){
        return new ArrayList<>(this.neighborhood);
    }

    public boolean containsNeighbor(Edge other){
        return this.neighborhood.contains(other);
    }
/*
    public String insertBook(String[] strings) {
        StringBuilder builder = new StringBuilder();
        for(String s : strings) {
            builder.append(s+" ");
        }

        String bookName = builder.substring(0,builder.length()-1).toString();
        this.books.insert(bookName);
        return null;
    }

    public String findBook(String[] findbook) {
        StringBuilder builder = new StringBuilder();
        for(String s : findbook) {
            builder.append(s+" ");
        }

        String bookName = builder.substring(0,builder.length()-1).toString();
        this.books.find(bookName);
        return null;
    }

    public void listBooks() {
        this.books.display();
    }*/
}
