package net.adman.flower.web.controller;

import java.text.ParseException;
import java.util.List;

import net.adman.flower.exception.InvalidValueException;
import net.adman.flower.model.Duration;
import net.adman.flower.model.Flower;
import net.adman.flower.service.ArrayAlgorithmService;
import net.adman.flower.service.DurationService;
import net.adman.flower.service.FlowerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("")
public class FlowerController {
	
	@Autowired private DurationService durationService;
	@Autowired private FlowerService flowerService;
	@Autowired private ArrayAlgorithmService arrayAlgorithmService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String index() {
		return "redirect:/flower/";
	}
	
	@RequestMapping(value="flower", method=RequestMethod.GET)
	public String home(Model model) throws ParseException {
		Duration duration = durationService.selectByStartAndEndDate("20130301", "20131201");
		
		if (duration != null) {
			List<Flower> rawResultList = flowerService.selectListByDurationId(duration.getId());
			List<Flower> resultList = flowerService.selectListWithOptimalResult(duration, rawResultList);
			model.addAttribute("rawResultList", rawResultList);
			model.addAttribute("resultList", resultList);
		}
		
		return "flower/home";
	}
	
	

	@RequestMapping(value="array_algorithm", method=RequestMethod.GET)
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
