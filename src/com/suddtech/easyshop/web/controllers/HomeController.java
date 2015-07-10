package com.suddtech.easyshop.web.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suddtech.easyshop.model.Offer;
import com.suddtech.easyshop.service.OfferService;
@Controller
public class HomeController {
	private static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private OfferService offerService;


	@RequestMapping("/")
public String showHome(Model model, Principal principal){
		
		List<Offer> offers = offerService.getCurrent();

		model.addAttribute("offers", offers);
		
		boolean hasOffer = false;
		
		if(principal != null) {
			hasOffer = offerService.hasOffer(principal.getName());
		}
		
		model.addAttribute("hasOffer", hasOffer);

		return "home";
	}

}

