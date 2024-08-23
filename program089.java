//write a code to find all paths from source to target using dfs method in graph(depth first search)
//Time complexity O(v^v)
//v = size of Arraylist

import java.util.ArrayList;

public class program089 {
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

    public static void dfs(ArrayList<Edge> graph[],int curr,boolean visited[]){
       
        //Queue<Integer> q = new LinkedList<>();
        //q.add(start);
        System.out.print(curr+" -- ");
        visited[curr] = true;
        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(visited[e.dest] == false){
                dfs(graph, e.dest, visited);
            }                           
        }
        //System.out.println();
    }
    public static void printAllPaths(ArrayList<Edge> graph[], boolean visited[], int curr,String path,int target){
        if(curr == target){
            System.out.println(path);
            return;
        }
        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                visited[curr] = true;
                printAllPaths(graph,visited,e.dest,path+" -- "+e.dest, target);
                visited[curr]=false;
            }
        }
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
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        int src =0;
        int target = 5;
        System.out.println("All paths from "+src+" to "+target+" :");
        printAllPaths(graph,new boolean[v],src,"0",target);
    }
}