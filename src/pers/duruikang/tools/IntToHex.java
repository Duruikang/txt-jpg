/**
 * 
 */
package pers.duruikang.tools;

import java.util.HashMap;
import java.util.Map;

public class IntToHex {
    public static String tenToSix(String content) {
    	int number=0;
        String [] HighLetter = {"a","b","c","d","e","f"};
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i <= 9;i++){
            map.put(i+"",i);
        }
        for(int j= 10;j<HighLetter.length+10;j++){
            map.put(HighLetter[j-10],j);
        }
        String[]str = new String[content.length()];
        for(int i = 0; i < str.length; i++){
            str[i] = content.substring(i,i+1);
        }
        for(int i = 0; i < str.length; i++){
            number += map.get(str[i])*Math.pow(16,str.length-1-i);
        }
        return Integer.toString(number);
    }
}
