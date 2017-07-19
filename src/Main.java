import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        Room[] rooms = new Room[10];

        String labels[] = new String[10];
        labels[0] = "Psychology";
        labels[1] = "History";
        labels[2] = "Engineering";
        labels[3] = "Sociology";
        labels[4] = "Biology";
        labels[5] = "Business";
        labels[6] = "Languages";
        labels[7] = "Tourism";
        labels[8] = "Mathematics";
        labels[9] = "Theology";
        int[][] matrix = new int[0][];
        try {
            BufferedReader input = new BufferedReader(new FileReader("input.txt"));
            matrix = new int[10][10];
            Scanner in = new Scanner(input);
            int lineCount = 0;
            while (lineCount < 10) {
                for (int i = 0; i < 10; i++) {
                    matrix[lineCount][i] = in.nextInt();
                    if (matrix[lineCount][i] == 0)
                        matrix[lineCount][i] = 999;
                }
                lineCount++;
            }
            input.close();
        } catch (IOException e) {
            System.out.println("Error reading");

        }

        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room(labels[i], i);
            graph.addRoom(rooms[i], true);
        }
        Prims p = new Prims(matrix, rooms);
        p.isVisited[0] = 1;
        p.calc(labels.length);
        Knapsack knapsack=new Knapsack();

        try {

            int i=0;
            BufferedReader input = new BufferedReader(new FileReader("input.txt"));
            String line = input.readLine();
            Scanner in = new Scanner(input);
           int j=0;
            while (line !=null) {
                line =input.readLine();
                j++;
                if (j > 9) {
                    if (line.compareTo("Psychology") == 0) {
                        int val[] = new int[9];
                        int wt[] = new int[9];
                        while (in.hasNextInt()) {
                            wt[i] = in.nextInt();
                            val[i] = in.nextInt();
                            i++;
                        }
                        i = 0;
                        System.out.println("Psychology : " + knapsack.knapsack(val, wt, 5));



                    }
                       if (line.compareTo("History")==0){
                                int val[] = new int[9] ;
                                int wt[] = new int[9];
                                while(in.hasNextInt()){
                                    wt[i] = in.nextInt();
                                    val[i] = in.nextInt();
                                    i++;
                                }

                                i=0;
                                System.out.println("History : "+knapsack.knapsack(val, wt, 5));


                            }
                    if (line.compareTo("Engineering") == 0) {
                        int val[] = new int[9];
                        int wt[] = new int[9];
                        while (in.hasNextInt()) {
                            wt[i] = in.nextInt();
                            val[i] = in.nextInt();
                            i++;
                        }


                        i = 0;
                        System.out.println("Engineering : " + knapsack.knapsack(val, wt, 5));
                        // break;
                       // continue;

                    }
                    if (input.readLine().compareTo("Sociology") == 0) {
                        int val[] = new int[9];
                        int wt[] = new int[9];
                        while (in.hasNextInt()) {
                            wt[i] = in.nextInt();
                            val[i] = in.nextInt();
                            i++;
                        }

                        i = 0;
                        System.out.println("Sociology : " + knapsack.knapsack(val, wt, 5));
                        // break;
                       //continue;
                    }
                    if (input.readLine().compareTo("Biology") == 0) {
                        int val[] = new int[9];
                        int wt[] = new int[9];
                        while (in.hasNextInt()) {
                            wt[i] = in.nextInt();
                            val[i] = in.nextInt();
                            i++;
                        }

                        i = 0;
                        System.out.println("Biology : " + knapsack.knapsack(val, wt, 5));
                        // break;
                        //continue;
                    }

                }
            }

input.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

     //   System.out.println(knapsack.knapsack(val, wt, W));

      /*  ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms.length; j++)
                if (rooms[i].equals(rooms[j]))
                    break;
                else if (matrix[i][j] != 0) {
                    Edge e = new Edge(rooms[i], rooms[j], matrix[i][j]);
                    edges.add(e);
                }
        }
        for (Edge e : edges) {
            graph.addEdge(e.getOne(), e.getTwo(), e.getWeight());
        }

*/
      /*  Dijkstra dijkstra = new Dijkstra(graph,rooms[0].getLabel());




        String result = null;
        int distance = 0;
        showMenu();
        while (true) {

            System.out.print("Input: ");
            Scanner input = new Scanner(System.in);
            String in = input.nextLine();
            String[] words = in.split(" ");

            switch (words[0].trim()) {
                case "Initialize":
                    dijkstra.setInitialRoomLabel(words[1].trim());
                    result = "Initialized." +dijkstra.getDistanceTo(words[1].trim())  + "m.";
                    break;
                case "Insert":
                    String[] book = Arrays.copyOfRange(words, 2, words.length);
                    distance = dijkstra.getDistanceTo(words[1].trim());
                    dijkstra.setInitialRoomLabel(words[1].trim());
                    for(Room r : rooms)
                    if(r.getLabel().compareTo(words[1]) ==0) {
                        result = r.insertBook(book)+" "+distance+" m.";

                        break;
                    }

                    break;
                case "Find":
                    String[] findbook = Arrays.copyOfRange(words, 2, words.length);
                    distance = dijkstra.getDistanceTo(words[1].trim());
                    dijkstra.setInitialRoomLabel(words[1].trim());
                    for(Room r : rooms)
                        if(r.getLabel().compareTo(words[1]) ==0) {
                            result = r.findBook(findbook)+" "+distance+" m.";

                            break;
                        }

                    break;
                case "List":
                    distance = dijkstra.getDistanceTo(words[1].trim());
                    dijkstra.setInitialRoomLabel(words[1].trim());
                    for(Room r : rooms)
                        if(r.getLabel().compareTo(words[1]) ==0) {
                            r.listBooks();
                            result = " "+distance+" m.";

                            break;
                        }

                    break;
                case "Location":
                    result = "Location:"+dijkstra.getInitialRoomLabel()+"."+dijkstra.getDistanceTo(dijkstra.getInitialRoomLabel())  + "m.";
                    break;
                case "Quit":
                    result = dijkstra.quit();
                    System.out.println("Output:" + result);
                    System.exit(0);
            }
            System.out.println("Output:" + result);


        }*/
    }
      /*
    private static void showMenu() {
        System.out.println("•\tInitialize \n" +
                "•\tInsert \t  \n" +
                "•\tFind\n" +
                "•\tList\n" +
                "•\tLocation\n" +
                "•\tQuit\n");
    }*/

}
