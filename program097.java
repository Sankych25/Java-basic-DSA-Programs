//Bridge in graph
//Write a program to find bridge in graph using dfs
//Time Complexity
//Tarjan's Algorithm
import java.util.ArrayList;

public class program097 {
    static class Edge{
        int src;
        int dest;

        //int wt;

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
           // this.wt = w;
        }

        // public Edge(int dest2, int src2) {
        //     //TODO Auto-generated constructor stub
        // }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
         
       
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,3));
        graph[0].add(new Edge(0,2));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[3].add(new Edge(3,5));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));
        
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));

        
    }
    public static void getBridge(ArrayList<Edge> graph[],int v){
        int dt[] = new int[v];  //dt --> discovery time
        int low[] = new int[v]; //lowest discovery time
        int time = 0;
        boolean visited[] = new boolean[v];

        for(int i=0; i<v; i++){
            if(!visited[i]){
                dfs(graph,i,visited,dt,low,time,-1);
            }
        }
    } 
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean visited[],int dt[],int low[], int time, int par){
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(e.dest == par){
                continue;
            }else if(!visited[e.dest]){
                dfs(graph, e.dest, visited, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(dt[curr] < low[e.dest]){
                    System.out.println("Bridge is : "+curr + " ---- "+e.dest);
                }
            }else{
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        /* 
          1 -- 0 -- 3 -- 5
          |   /      \   |
          |  /         \ |
           2             4
         */
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        getBridge(graph, v);
    }
}
