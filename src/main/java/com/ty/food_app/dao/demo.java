package com.ty.food_app.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class demo {
	public static void main(String[] args) {
		String str ="hello hi bye hello";
		
		
		String [] words = str.split(" ");
		
		
		HashMap< String,Integer> hashMap = new HashMap<>();
		
		for(String word :words){
			Integer integer= hashMap.get(word);
			if(integer== null) {
				hashMap.put(word, 1);
			}
			else {
				hashMap.put(word, integer+1);
			}
			System.out.println(hashMap);
		}
		
		
		
	}

}
