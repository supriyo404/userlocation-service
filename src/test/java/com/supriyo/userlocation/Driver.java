package com.supriyo.userlocation;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;

public class Driver {

    public static void main(String[] args) {

        String s = "Hi my name is rituparna";
        String[] str = s.split("\\s+");


    }

    private static String reverserString(String s){
        if(s.isBlank()||s==null){
            return s;
        }

        return s.charAt(s.length()-1)+ reverserString(s.substring(0,s.length()-1));


    }
}
