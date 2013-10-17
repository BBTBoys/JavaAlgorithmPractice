package net.adman.flower.service;

import org.springframework.stereotype.Service;

@Service
public class HeapSortServiceImpl implements HeapSortService {

	@Override
	public int[] excuteHeapSort(int[] inputArray) {
		if (inputArray != null && inputArray.length > 0) {
			int count = inputArray.length;
			
			heapify(inputArray, count);
			
			int end = count - 1;
			while(end > 0) {
				swap(inputArray, end, 0);
				end = end - 1;
				siftDown(inputArray, 0, end);
			}
			return inputArray;
		}
		return null;
	}
	
	private void heapify(int[] inputArray, int count) {
		int start = (count - 2) / 2;
		
		while(start >= 0) {
			siftDown(inputArray, start, count-1);
			start = start - 1;
		}
	}

	private void siftDown(int[] inputArray, int start, int end) {
		int root = start;
		
		while(root*2+1 <=end) {
			int child = root * 2 + 1;
			int swap = root;
			
			if (inputArray[swap] < inputArray[child]) {
				swap = child;
			}
			
			if (child+1 <= end && inputArray[swap] < inputArray[child+1]) {
				swap = child + 1;
			}
			
			if (swap != root) {
				swap(inputArray, root, swap);
				root = swap;
			} else {
				return;
			}
		}
	}

	private void swap(int[] inputArray, int i, int j) {
		int swapValue = inputArray[i];
		
		inputArray[i] = inputArray[j];
		inputArray[j] = swapValue;
	}

}
