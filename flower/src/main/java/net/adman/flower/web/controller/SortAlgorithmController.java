package net.adman.flower.web.controller;

import java.util.List;

import net.adman.flower.service.SortService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Lists;

@Controller
@RequestMapping("sort_algorithm")
public class SortAlgorithmController {
	
	@Autowired private SortService sortService;

	@RequestMapping("")
	public String home() {
		return "sort/home";
	}
	
	@RequestMapping(value="quick_sort", method=RequestMethod.GET)
	public String simpleSort(Model model,
			@RequestParam("sortType") String sortType,
			@RequestParam("values") List<Integer> values) {
		
		if (values.size() > 1) {
			model.addAttribute("rawDataList", values);
			if ("simple".equals(sortType)) {
				model.addAttribute("resultList", sortService.getSimpleSorting(values));
			} else if ("placeIn".equals(sortType)) {
				List<Integer> inputList = Lists.newArrayList();
				inputList.addAll(values);
				model.addAttribute("resultList", sortService.getPlaceInTypeSorting(inputList));
			}
			model.addAttribute("type", sortType);
		}
		
		return "sort/result";
	}
}
