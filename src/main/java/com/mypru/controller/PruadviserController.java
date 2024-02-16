package com.mypru.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mypru.entity.PruadviserEntity;
import com.mypru.globalexceptionhandler.PruadviserNotFoundException;
import com.mypru.service.PruadviserService;

@RestController
@RequestMapping("/api")
public class PruadviserController {
	private final PruadviserService pruadviserservice;
	private static final org.slf4j.Logger logger=LoggerFactory.getLogger(PruadviserController.class);
	
	public PruadviserController(PruadviserService pruadviserservice) {
		this.pruadviserservice = pruadviserservice;
	}
	@GetMapping("/getalldetails")
	public List<PruadviserEntity> getAllPruadviser()
	{ 
		try {
			 List<PruadviserEntity> pruadviser=pruadviserservice.getAllDetails();
		     logger.info("The pruadviser details fetched successfully");
		     return pruadviser;
	}
		catch(PruadviserNotFoundException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pruadviser details not found");
		}
	}
	@GetMapping("/pruadviser/{pruadviserName}")
	public ResponseEntity<?> getPruadviserDetailsByName(@PathVariable String pruadviserName)
	{
		try {
			PruadviserEntity pruadviser=pruadviserservice.getPruadviserDetailsByName(pruadviserName);
			logger.info("the pruadviser details are fetched by name" +pruadviserName);
			return ResponseEntity.ok(pruadviser);
		}
		catch(PruadviserNotFoundException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pruadviser details not found");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPruadviserDetailsById(@PathVariable Long id)
	{
		 try {
		PruadviserEntity pruadviser=pruadviserservice.getPruadviserDetailsByID(id);
		if(pruadviser!=null) {
		logger.info("Pruadviser details are fetched successfully with:"+id);
		return ResponseEntity.ok(pruadviser);
		 }
		else {
			 logger.warn("No pruadviser details found with id:"+id);
			 return ResponseEntity.notFound().build();
		 }}
		 catch(PruadviserNotFoundException e)
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pruadviser details not found");
			
		 }
	}
	@PostMapping("/save")
	public PruadviserEntity saveAllPruadviser(@RequestBody PruadviserEntity pruadv)
	{
		return pruadviserservice.saveAdviserDetails(pruadv);
	}
	@DeleteMapping("/delete")
	public void deleteAdviserDetails()
	{
		pruadviserservice.deleteAdviser();
	}
	@DeleteMapping("/{id}")
	public void deleteAdviserDetailsById(@PathVariable Long id)
	{
		pruadviserservice.deleteAdviserDetailsById(id);
	}


}
