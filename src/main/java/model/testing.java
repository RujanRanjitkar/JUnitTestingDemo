package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testing {
    public static void main(String[] args) {
        String[] str={"flower","flow","flight","flom"};
        List<String> strings=new ArrayList<>();
        int min=0;
        for (int i=0;i< str.length-1;i++){
            min=Math.min(str[i].length(),str[i+1].length());
        }
        System.out.println(min);

        for(int i=0;i< str.length- (str.length-1);i++){
            for(int k=1;k< str.length;k++){
                int j=1;
                while (j<min) {
                    if(str[i].substring(0, j).equals(str[k].substring(0, j))  ) {
                        System.out.println(str[i].substring(0, j));
                        strings.add(str[i].substring(0, j));
                    }
                    j++;
                }
            }

        }
        System.out.println(strings);
        String s="";
        for (int i=0;i<strings.size();i++){
            s= strings.get(i);
        }
        System.out.println(s);
    }
}
