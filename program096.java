//Strongly connected component(SCC) is a component in which we can reach every vertex of the component from every other vertex in that component
//Kasaraju's Algorithm
//It works for SCC. kasarajus algorithm is used for find SCC component. It warks on only directed graph
//Time complexity O(V + E)
//kosaraju's Algorithm
import java.util.ArrayList;
import java.util.Stack;

/**
 * program096
 */
public class program096 {

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
         
       
        //graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3));
        graph[0].add(new Edge(0,2));

        //graph[4].add(new Edge(4,1,-1));
        //graph[4].add(new Edge(4,5,5));
        
        graph[1].add(new Edge(1,0));
        //graph[1].add(new Edge(1,3,40));

        //graph[3].add(new Edge(3,1,10));
        //graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,4));
        
        graph[2].add(new Edge(2,1));
        //graph[2].add(new Edge(2,3,50));

        
    }
    public static void topsort(ArrayList<Edge> graph[],int curr,boolean visited[],Stack<Integer> s){
        visited[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topsort(graph, e.dest, visited, s);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean visited[]){
        visited[curr] = true;
        System.out.print(curr + " ");

        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void kosaraju(ArrayList<Edge> graph[],int v){
        //Step 1
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                topsort(graph, i, visited, s);
            }
        } 
        //step 2
        ArrayList<Edge> transpose[] = new ArrayList[v];
        //ArrayList<Edge> transpose = new ArrayList[v];
        for(int i=0; i<v; i++){
            transpose[i] = new ArrayList<Edge>();
        }
        for(int i=0; i<v; i++){
            visited[i] = false;
            for(int j=0; j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }
        //step 3
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!visited[curr]){
                System.out.print("SCC : ");
                dfs(transpose, curr, visited);
                System.out.println();
            }
        }

    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        /* 
          1 --> 0 --> 3 --> 4
          ^     |
          |     |
          2 <----
        */
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        kosaraju(graph, v);
    }
}