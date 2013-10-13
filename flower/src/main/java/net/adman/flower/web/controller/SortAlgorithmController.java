package net.adman.flower.web.controller;

import java.util.List;

import net.adman.flower.service.SortService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("sort_algorithm")
public class SortAlgorithmController {
	
	@Autowired private SortService sortService;

	@RequestMapping("")
	public String home() {
		return "sort/home";
	}
	
	@RequestMapping(value="simple_sort", method=RequestMethod.GET)
	public String simpleSort(Model model,
			@RequestParam("values") List<Integer> values) {
		
		if (values.size() > 1) {
			model.addAttribute("rawDataList", values);
			model.addAttribute("resultList", sortService.getSimpleSorting(values));
			model.addAttribute("type", "simple_sort");
		}
		
		return "sort/simple_sort";
	}
}
