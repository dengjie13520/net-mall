package myMapper;


import java.util.HashMap;



public interface Mall_top {
   public int createNewUser(HashMap<String,String> mymap);
   public HashMap<String,String> lookPassword(String name);
}
