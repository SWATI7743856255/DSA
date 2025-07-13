// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
       int[] pre=new int[]{1,2,-1,-1,3,-1,-1};
       Node root=buildTree(pre);
       
       InOrderTree(root);
       
    }
    
    static int index=-1;
    public static Node buildTree(int[] pre)
    {
        
        index++;
        if(pre[index]==-1){
            return null;
        }
        Node root=new Node(pre[index]);
        root.left=buildTree(pre);
        root.right=buildTree(pre);
        
        return root;
        
    }
    
    public static void InOrderTree(Node root)
    {
        if(root==null){
            return;
        }
        
        System.out.println(root.data);
        InOrderTree(root.left);
        InOrderTree(root.right);
        
    }
}



class Node{
    int data;
    Node left;
    Node right;
    
    Node(int val){
        data=val;
        left=null;
        right=null;
    }
    
}
