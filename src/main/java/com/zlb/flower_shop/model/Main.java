package com.zlb.flower_shop.model;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n,m;
        Scanner cin = new Scanner(System.in);
        String[] string =  new String[15];
        List<String> list = new ArrayList<>();
        n=cin.nextInt();
        for (int i = 0; i < n; i++) {
            m=cin.nextInt();
            cin.nextLine();

            for (int j = 0; j < m; j++) {
                string[j] = cin.nextLine();
                //System.out.println(string[j]);
            }
            int len=60;
            String s;
            list.clear();
            while(len>0){
                boolean fag=false;
                for (int j = 0; j < 60; j++) {
                    if(j+len>60)
                        break;
                    s=string[0].substring(j,j+len);
                    int k;
                    for (k= 1; k < m; k++) {
//                        System.out.println(s);
//                        System.out.println(string[i].indexOf(s));
                        if(string[k].indexOf(s)==-1)
                            break;
                    }

                    if(k>=m){
                        list.add(s);
                        fag=true;
                    }
                }
                if(fag)
                    break;
                len--;
            }
            Collections.sort(list);
            if(list.size()==0||list.get(0).length()<3)
                System.out.println("no significant commonalities");
            else
             System.out.println(list.get(0));
        }
    }
}
