import java.util.*; // Use this instead

class Main{
    public static void main(String[] args){
        System.out.println("Hello graph");
        
        int n=5;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
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
        
    }
}
