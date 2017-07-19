import java.util.*;
public class Prims
{
    public  int isVisited[] = new int[15];
    public  int cost[][] = new int[10][10];
    public int minimum_cost;
    public Room[] rooms;
    public Prims(int cost[][], Room[] rooms){
        this.rooms=rooms;
        this.cost = cost;
    }
    public void calc(int n)
    {
        int flag[] = new int[n+1];
        int i,j,min=999,num_edges=1,a=1,b=1,minpos_i=1,minpos_j=1;

        int totalDistance = 0;
        while(num_edges < n)
        {

            for(i=0,min=999;i<n;i++)
                for(j=0;j<n;j++)
                    if(this.cost[i][j]<min)
                        if(this.isVisited[i]!=0)
                        {
                            min=this.cost[i][j];
                            a=minpos_i=i;
                            b=minpos_j=j;
                        }
            if(this.isVisited[minpos_i]==0 || this.isVisited[minpos_j]==0)
            {
                String from=null,to=null;
                for(Room r : rooms){
                    if(r.getKey()==a)
                        from=r.getLabel();
                    else if(r.getKey()==b)
                        to=r.getLabel();
                }
                totalDistance += min;
                System.out.println(from+"-"+to+":"+min+" \n");
                this.minimum_cost=this.minimum_cost+min;
                num_edges=num_edges+1;
                this.isVisited[b]=1;
            }
            this.cost[a][b]=this.cost[b][a]=999;


        }
        System.out.println("Total Lenghth of the MST :"+totalDistance+" \n");


    }

}