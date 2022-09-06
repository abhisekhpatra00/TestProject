package com.aviweb.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aviweb.service.IService;

@RestController
@RequestMapping("/main")
public class MyController {
    @Autowired
	private IService service;
	@GetMapping("/check")
	public ResponseEntity<String> check() {
		return new ResponseEntity<String>("working",HttpStatus.OK);
		
	}
	@PostMapping("/name")
	public ResponseEntity<?> getNeme(@RequestBody List<String> listName){
	   Map<Character,String> mapName=service.getTheName(listName); 	
	
	   Map<Character,String> nameMap = new HashMap<Character, String>();
	   Map<Character,String> sortedMap = new HashMap<Character, String>();
	   listName.stream().forEach(name->{
		 nameMap.put(name.charAt(0), name);
		   
		   
	   });
	   nameMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(map ->{
		   sortedMap.put(map.getKey(), map.getValue());
	   });
		//return new ResponseEntity<>(sortedMap,HttpStatus.OK); 
		return new ResponseEntity<>(mapName,HttpStatus.OK); 
		
		
	}
}
