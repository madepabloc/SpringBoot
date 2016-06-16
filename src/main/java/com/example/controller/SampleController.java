package com.example.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.PricesList;
import com.example.model.PricesListDao;

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
	
	@RequestMapping("/getAllPricesList")
	@ResponseBody
	public String gelAllPricesList(){
		 Collection<PricesList> pricesList = (Collection<PricesList>) pricesListDao.findAll();
		 String result = "";
		 for(PricesList pl:pricesList){
			 result = result + pl.getDescription();
		 }
		 return result;
	}

}
