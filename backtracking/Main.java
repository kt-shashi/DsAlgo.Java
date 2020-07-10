package com.shashi.dsalgo.backtracking;;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Question 1:

        //First non repeating char
        //a green apple -> g

        char ch1=findFirstNonRepeatingChar("a applel g");
        if(ch1!=0)
            System.out.println("First non repeating char: "+ch1);
        else
            System.out.println("No non repeating characters");

        //Question 2:

        //First repeating char
        //green apple r -> r

        char ch2=findFirstRepeatingChar("green apple r");
        if(ch2!=0)
            System.out.println("First repeating char: "+ch2);
        else
            System.out.println("No repeating characters");

    }

    public static char findFirstRepeatingChar(String str){

        //Add char to string from right
        //if already present, add char to output_variable
        //otherwise, add to set
        //return set

        Set<Character> set=new HashSet<>();

        char[] chars=str.toCharArray();
        char output=0;

        for(int i=chars.length-1;i>=0;i--){
            if(set.contains(chars[i])){
                output=chars[i];
            }else{
                set.add(chars[i]);
            }
        }

        return output;
    }

    public static char findFirstNonRepeatingChar(String str){

        //Add char to hashset as key, and set the value as 1
        //If char is already present, set the value as prev_value+1
        //iterate through the char array
        //if you find any value ==1, then return

        Map<Character,Integer> map=new HashMap<>();

        char[] chars=str.toCharArray();

        for(char ch: chars){
            int count=map.containsKey(ch)? map.get(ch) : 0;
            map.put(ch,count+1);
        }

        for(char ch: chars){
            if(map.get(ch)==1){
                return ch;
            }
        }

        return 0;
    }
}

