package com.mariathecharmix.sd.ereservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador para controlar el login personalizado
 * @author maria
 *
 */
@Controller
@RequestMapping("app")
public class LoginController {
	
	@GetMapping(value={"/", "/login"})
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		String errorMessage = "Usuario no autenticado, debe identificarse.";
		mav.addObject("errorMsg", errorMessage);
		mav.setViewName("login");
		return mav;
	}
	
	@GetMapping(value="/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
	
	

}
