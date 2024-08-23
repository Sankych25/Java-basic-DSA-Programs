//write a code to perform basic funcion on hashmap(collection framework)
import java.util.*;
public class  program073{
    public static void main(String args[]){
        HashMap<String,Integer> map = new HashMap<>();
        
        //insert values in hashmap
        map.put("India",120);
        map.put("China",150);
        map.put("USA",30);
        map.put("UK",100);
        
        //print map values
        System.out.println(map);

        //update values
        map.put("India",160);

        //search operation 
        if(map.containsKey("China")){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

        //get value with key
        System.out.println(map.get("China"));//if key is not present it returns null

        //to apply for loop on map
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println(e.getKey()+" : "+e.getValue());
        }

        //remove pair of key
        map.remove("China");
    }
}
