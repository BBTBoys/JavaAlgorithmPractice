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

}
