// Articulation point --> a vertex in an undirected connected graph is an articulation point(or cut vertex)
//if removing it(and edges through it) disconnects the graph
//write a program to find articulation point in graph
//Time complexity O(V + E)

import java.util.ArrayList;

public class program098 {
    static class Edge{
        int src;
        int dest;

        //int wt;

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
           // this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
         
       
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,3));
        graph[0].add(new Edge(0,2));

        graph[4].add(new Edge(4,3));
        //graph[4].add(new Edge(4,5));
        
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        //graph[3].add(new Edge(3,5));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));
        
        //graph[5].add(new Edge(5,3));
        //graph[5].add(new Edge(5,4));

        
    }
    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean visited[], int time, boolean ap[]){
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;
            if(par == neighbour){
                continue;
            }else if(visited[neighbour]){
                low[curr] = Math.min(low[curr], dt[neighbour]);
            }else {
                dfs(graph, neighbour, curr, dt, low, visited, time, ap);
                low[curr] = Math.min(low[curr], low[neighbour]);
            
                if(dt[curr] <= low[neighbour] && par != -1){
                    ap[curr] = true;
                }
                children++;
            }
        }
        if(par == -1  && children > 1){
            ap[curr] = true;
        }
    }
    public static void getAP(ArrayList<Edge> graph[], int v){
        int dt[] = new int[v];
        int low[] = new int[v];
        int time = 0;
        boolean visited[] = new boolean[v];
        boolean ap[] = new boolean[v];

        for(int i=0; i<v; i++){
            if(!visited[i]){
                dfs(graph, 1, -1, dt, low, visited, time, ap);
            }
        }
        for(int i=0; i<v; i++){
            if(ap[i]){
                System.out.println("Ap is  : "+ i);
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
        int v=6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        getAP(graph, v);
    }
}
