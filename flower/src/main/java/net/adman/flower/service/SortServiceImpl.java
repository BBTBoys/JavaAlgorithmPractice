package net.adman.flower.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class SortServiceImpl implements SortService {

	@Override
	public List<Integer> getSimpleSorting(List<Integer> dataList) {
		if (dataList != null && dataList.size() > 1) {
			return calculateSimpleSort(dataList);
		}
		return null;
	}
	
	private List<Integer> calculateSimpleSort(List<Integer> dataList) {
		if (dataList.size() <= 1) {
			return dataList;
		}
		
		int pivot = dataList.size() / 2;
		int pivotValue = dataList.get(pivot);
		List<Integer> adjustList = Lists.newArrayList();
		
		for(int i = 0; i < dataList.size(); i++) {
			if (i == pivot) {
				continue;
			}
			
			adjustList.add(dataList.get(i));
		}
		
		List<Integer> lessList = Lists.newArrayList();
		List<Integer> greaterList = Lists.newArrayList();
		for(int value : adjustList) {
			if (value <= pivotValue) {
				lessList.add(value);
			} else {
				greaterList.add(value);
			}
		}
		
		return cancatenate(calculateSimpleSort(lessList), pivotValue, calculateSimpleSort(greaterList));
	}
	
	private List<Integer> cancatenate(List<Integer> left, Integer pivotValue, List<Integer> right) {
		List<Integer> resultList = Lists.newArrayList();
		
		resultList.addAll(left);
		resultList.add(pivotValue);
		resultList.addAll(right);
		
		return resultList;
	}
	
	@Override
	public List<Integer> getPlaceInTypeSorting(List<Integer> inputList) {
		if (inputList != null && inputList.size() > 1) {
			List<Integer> resultList = Lists.newArrayList();
			int left = 0;
			int right = inputList.size()-1;
			resultList = quickSortWithPlaceInType(inputList, left, right); 
			return  resultList;
		}
		return null;
	}
	
	private List<Integer> quickSortWithPlaceInType(List<Integer> inputList, int left, int right) {
		if (right > left) {
			int pivotIndex = (left+right) / 2;
			int pivotNewIndex = patition(inputList, left, right, pivotIndex);
			quickSortWithPlaceInType(inputList, left, pivotNewIndex-1);
			quickSortWithPlaceInType(inputList, pivotNewIndex+1, right);
		}
		return inputList;
	}
	
	private int patition(List<Integer> inputList, int left, int right, int pivotIndex) {
		Integer pivotValue = inputList.get(pivotIndex);
		swap(inputList, right, pivotIndex);
		
		int storeIndex = left;
		for(int i = left; i < right; i++) {
			if (inputList.get(i) <= pivotValue) {
				swap(inputList, storeIndex, i);
				storeIndex = storeIndex + 1;
			}
		}
		swap(inputList, right, storeIndex);
		return storeIndex;
	}
	
	private void swap(List<Integer> list, int i, int j) {
		Integer swapValue = list.get(i);
		list.set(i, list.get(j));
		list.set(j, swapValue);
	}
}
