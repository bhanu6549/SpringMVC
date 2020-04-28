package com.mindtree.mobilestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.mobilestore.entity.Mobile;
import com.mindtree.mobilestore.service.MobileService;


@Controller
public class MobileController {
	@Autowired
	MobileService mobSer;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		//List<Mobile> listMobile = mobSer.listAll();
		//model.addAttribute("listMobiles",listMobile);
		return "index1";
	}

	@RequestMapping("/new")
	public String showNewMobilePage(Model model) {
		Mobile mobile = new Mobile();
		model.addAttribute("mobile", mobile);

		return "index1";
	}

	@RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveEmployee(@ModelAttribute("mobile") Mobile mobile) {
		mobSer.save(mobile);

		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("new_mobile");
		Mobile mobile = mobSer.get(id);
		mav.addObject("mobile", mobile);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") long id) {
		mobSer.delete(id);
		return "redirect:/";
	}

}
