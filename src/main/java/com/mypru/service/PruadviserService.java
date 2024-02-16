package com.mypru.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypru.entity.PruadviserEntity;
import com.mypru.globalexceptionhandler.PruadviserNotFoundException;
import com.mypru.pruadviserinterface.PruadviserInterface;

import jakarta.transaction.Transactional;

@Service
public class PruadviserService {
	Logger logger = LoggerFactory.getLogger(PruadviserService.class);
	@Autowired
	private PruadviserInterface pruadviserinterface;
	
    public PruadviserService(PruadviserInterface pruadviserinterface) {
		this.pruadviserinterface = pruadviserinterface;
	}
     public List<PruadviserEntity> getAllDetails()
     {
    	 return pruadviserinterface.findAll();
     }
     
     public PruadviserEntity getPruadviserDetailsByID(Long id)
     { 
    	 Optional<PruadviserEntity>  optionalpruadviser=pruadviserinterface.findById(id);
    	 
    	 return optionalpruadviser.orElseThrow(()->new PruadviserNotFoundException("The pruadviser details not found:" +id));
    	 
     
    	 
     }
     public PruadviserEntity getPruadviserDetailsByName(String pruadviserName)
     {
    	 Optional<PruadviserEntity> optionalpru=pruadviserinterface.getByPruadviserName(pruadviserName);
    	 return optionalpru.orElseThrow(()->new PruadviserNotFoundException("The given name is not found:"+pruadviserName));
     }
     
     @Transactional
     public PruadviserEntity saveAdviserDetails(PruadviserEntity pruadviser)
     {
      return pruadviserinterface.save(pruadviser);
     
      
     }
     
     public void deleteAdviser()
     {
    	 pruadviserinterface.deleteAll();
     }
     @Transactional
     public void deleteAdviserDetailsById(Long id)
     {
    	 pruadviserinterface.deleteAllById(id);
     }
     
}
