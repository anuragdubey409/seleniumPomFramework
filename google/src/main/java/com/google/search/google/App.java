/**

Ignore This class as this is src/main/java

We deal with the test folder in automation framework

**/





package com.google.search.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App 
{
    public static void main( String[] args )
    {
    	List<String> l2 = new ArrayList<String>();
    	Map<String,List<String>> key=new HashMap<String, List<String>>();
    	l2.add("I Am");
    	l2.add("The Cult");
    	l2.add("Of");
    	l2.add("Personality");
    	key.put("About Me",l2);
    	
//    	for(String s1:key.keySet()) {
//    		
//    		for(String s:key.get(s1)) {
//    			System.out.println(" The value of hasmap list is :- ' "+s1 +" ' is :- "+s);
//    		}
//    	}
    	
    	  key.forEach((keys, value)->
    	  	{System.out.println(
                          "Continent name : " + keys + "\t\t"
                          + "List of Top Countries : " + value);
    	  		});
    	  	
    	
    }
}
