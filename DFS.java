import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello graph World");
        
        int n=5;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            graph.add(new ArrayList<>());
        }
        
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(1);
        graph.get(2).add(4);
        graph.get(2).add(5);
        graph.get(3).add(1);
        graph.get(4).add(3);
        graph.get(4).add(2);
        graph.get(4).add(5);
        graph.get(5).add(2);
        graph.get(5).add(4);
        
        for(int i=1;i<=n;i++)
        {
            System.out.print(i+"->");
            for(int j=0;j<graph.get(i).size();j++)
            {
                System.out.print(graph.get(i).get(j));
            }
            System.out.println();
        }
        System.out.print("BFS->");
        bfs(graph,n,1);
         System.out.println();
        System.out.print("DFS->");
        dfs(graph,n,1);
        
        
    }
    
    
    public static void bfs(ArrayList<ArrayList<Integer>> graph,int n,int s)
    {
        boolean[] vis=new boolean[n+1];
        
        Queue<Integer> q=new LinkedList<>();
        
        q.offer(s);
        vis[s]=true;
        
        while(!q.isEmpty()){
          
            int cur = q.poll();
            System.out.print(cur);
            
            for(int i=0;i<graph.get(cur).size();i++){
                int adj=graph.get(cur).get(i);
                if(!vis[adj])
                {
                    q.offer(adj);
                    vis[adj]=true;
                }
            }
        }
    }
    
    
    public static void dfs(ArrayList<ArrayList<Integer>> graph,int n,int s)
    {
        boolean[] dvis=new boolean[n+1];
        
        Stack<Integer> st=new Stack<>();
        
        st.push(s);
        
        
        while(!st.isEmpty()){
          
            int cur = st.pop();
            
            
            if(!dvis[cur])
                {
                    System.out.print(cur);
                    
                    dvis[cur]=true;
                }
            
            for(int i=0;i<graph.get(cur).size();i++){
                int adj=graph.get(cur).get(i);
                if(!dvis[adj])
                {
                    st.push(adj);
                    
                }
            }
        }
        
        
        
  
        
        
        
    }
    
    
    
}
