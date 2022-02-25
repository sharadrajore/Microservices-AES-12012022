package com.zensar.controllers;

import java.security.Principal;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobPortalController {
	// http://localhost:8080
	@GetMapping("/")
	public String getMessage(Principal principal) {
		OAuth2AuthenticationToken oAuth2AuthenticationToken=(OAuth2AuthenticationToken)principal;
	
		System.out.println(principal);
			return "Hello "+ oAuth2AuthenticationToken.getPrincipal().getAttribute("login");
	}

}
