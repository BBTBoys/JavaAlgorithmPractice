package net.adman.flower.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sort_algorithm")
public class SortAlgorithmController {

	@RequestMapping("")
	public String home() {
		return "sort/home";
	}
}
