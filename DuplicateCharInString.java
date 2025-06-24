
import java.util.HashMap;
import java.util.Map;
class Main{
    public static void main(String[] args){
        String s = "geeksforgeeks";

        printDuplicates(s);
    }
    
    public static void printDuplicates(String s){
        HashMap<Character,Integer> hs=new HashMap<>();
        for(int i=0;i<s.length();i++){
            
            hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1);
        }
        
       
        for(Map.Entry<Character,Integer> e:hs.entrySet())
        {
            
            if(e.getValue()>=2){
                System.out.println(e.getKey()+"-"+e.getValue());
            }
        }
        
    }
}
