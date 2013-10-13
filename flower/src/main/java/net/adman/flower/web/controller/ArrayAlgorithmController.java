package net.adman.flower.web.controller;

import net.adman.flower.exception.InvalidValueException;
import net.adman.flower.service.ArrayAlgorithmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("array_algorithm")
public class ArrayAlgorithmController {
	
	@Autowired private ArrayAlgorithmService arrayAlgorithmService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String home(Model model,
			@RequestParam("size") int size) throws InvalidValueException {
		if (size < 1) {
			throw new InvalidValueException(size);
		}
		
		model.addAttribute("dataList", arrayAlgorithmService.calculateZigZagMatrix(size));
		model.addAttribute("size", size);
		
		return "array/home";
	}
}
