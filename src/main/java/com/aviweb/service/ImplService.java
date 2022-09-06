package com.aviweb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public class ImplService implements IService{

	@Override
	public Map<Character, String> getTheName(List<String> listName) {
		Map<Character,String> newMap = new HashMap<>();
       	
		
		listName.forEach(name->{
			int spaceIndex = name.indexOf(" ");
			if(name.charAt(spaceIndex+1)=='p') {
				newMap.put(name.charAt(0), name);
			}
			
			
		});
		return newMap;
	}

}
