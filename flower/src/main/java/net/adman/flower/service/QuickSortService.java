package net.adman.flower.service;

import java.util.List;

import net.adman.flower.model.MergeSort;


public interface QuickSortService {

	List<Integer> getSimpleSorting(List<Integer> dataList);
	
	List<Integer> getPlaceInTypeSorting(List<Integer> inputList);
	
	List<Integer> getMergeSorting(MergeSort mergeSort);
}
