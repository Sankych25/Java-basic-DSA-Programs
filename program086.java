//write a code to create nodes of graph and print nodes using bfs method in graph(Breadth first search)[connected graph]
//Time complexity O(v+E)
//v = size of Arraylist
//E = number of edges
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class program086 {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
         
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(5,6,1));
    }    

    public static void bfs(ArrayList<Edge> graph[],int v){
        boolean visited[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr+ " --> ");
                visited[curr] = true;

                for(int i=0; i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
         /*
            1 -- 3
           /     | \
          0      |  5 -- 6
           \     | /
            2 -- 4 

         */
        int v = 7;
        ArrayList<Edge> []graph = new ArrayList[v];
        createGraph(graph);
        System.out.println("Output of graph using BFS :");
        bfs(graph,v);
    }
}
