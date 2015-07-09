package com.suddtech.easyshop.web.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.suddtech.easyshop.model.Offer;
import com.suddtech.easyshop.service.OfferService;

@Controller
public class OffersController {
	private OfferService offerService;

	@RequestMapping("/offers")
	public String showOffers(Model model) {

		List<Offer> offers = offerService.getCurrent();

		model.addAttribute("offers", offers);
		return "offers";
	}

	@RequestMapping("/createoffer")
	public String creatOffer(Model model, Principal principal) {
		Offer offer = null;
		if (principal != null) {
			String username = principal.getName();
			offer = offerService.getOffer(username);
		}
		if (offer == null) {
			offer = new Offer();
		}
		model.addAttribute("offer", new Offer());
		return "createoffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer,
			BindingResult result, Principal principal,
			@RequestParam(value = "delete", required = false) String delete) {

		if (result.hasErrors()) {
			//
			// // System.out.println("Form not valid");
			// List<ObjectError> errors = result.getAllErrors();
			//
			// for (ObjectError error : errors) {
			// System.out.println(error.getDefaultMessage());
			//
			// }

			return "createoffer";
		}
		if (delete == null) {
			String username = principal.getName();
			offer.getUser().setUsername(username);
			offerService.saveOrUpdate(offer);
			return "offercreated";
		} 
		else {
			offerService.delete(offer.getId());
			return "offerdeleted";
		}
	}

	@Autowired
	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}

}
