package com.example.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.PricesList;
import com.example.model.PricesListDao;
import com.google.gson.Gson;



@Controller
@EnableAutoConfiguration
public class SampleController {
	
	@Autowired(required = true)
	private PricesListDao pricesListDao;
	
	@RequestMapping("/")
	@ResponseBody
	String home(){
		return "Hello World";
	}
	

	
	@RequestMapping(value = "/getAllPricesList",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> gelAllPricesList(){
		Gson gson = new Gson();
		
		Collection<PricesList> pricesList = (Collection<PricesList>) pricesListDao.findAll();
	 	return new ResponseEntity<String>(gson.toJson(pricesList), HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/getPricesList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> getPriceListByIdSap(
			@RequestParam(value="idSap") Integer idSap){
		PricesList pricesList = new PricesList();
		Gson gson = new Gson();
		
		pricesList = (PricesList) pricesListDao.findByIdSap(idSap);
		
 		if (pricesList != null){
 			return new ResponseEntity<String>(gson.toJson(pricesList), HttpStatus.OK);
 		}else{
 			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
 		}		 		
	}
	

}
