package net.adman.flower.web.controller;

import java.util.List;

import net.adman.flower.model.MergeSort;
import net.adman.flower.service.HeapSortService;
import net.adman.flower.service.QuickSortService;

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
	
	@Autowired private QuickSortService sortService;
	@Autowired private HeapSortService heapSortService;

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
	
	@RequestMapping(value="merge_sort", method=RequestMethod.GET)
	public String mergeSort(Model model) {
		List<Integer> inputList =Lists.newArrayList();
		inputList.add(3);
		inputList.add(7);
		inputList.add(4);
		inputList.add(9);
		inputList.add(5);
		inputList.add(2);
		inputList.add(6);
		inputList.add(1);
		
		MergeSort mergeSort = new MergeSort(inputList.size()-1, inputList);
		
		model.addAttribute("rawDataList", mergeSort.getInputList());
		model.addAttribute("resultList", sortService.getMergeSorting(mergeSort));
		
		return "sort/merge_sort";
	}
	
	@RequestMapping(value="heap_sort", method=RequestMethod.GET)
	public String heapSort(Model model) {
		int[] inputArray = {6,5,3,1,8,7,2,4};
		int[] rawDataList = {6,5,3,1,8,7,2,4};
		int[] resultArray = heapSortService.excuteHeapSort(inputArray);
		
		model.addAttribute("rawDataList", rawDataList);
		model.addAttribute("resultList", resultArray);
		
		return "sort/heap_sort";
	}
}
