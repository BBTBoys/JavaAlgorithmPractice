package net.adman.flower.model;

import java.util.List;

import com.google.common.collect.Lists;

public class MergeSort {
	
	private List<Integer> inputList;
	private List<Integer> outputList;
	private int n;
	
	public MergeSort(int n, List<Integer> inputList) {
		this.n = n;
		this.inputList = inputList;
		this.outputList = Lists.newArrayList();
		this.outputList.addAll(this.inputList);
	}

	public List<Integer> getInputList() {
		return inputList;
	}

	public void setInputList(List<Integer> inputList) {
		this.inputList = inputList;
	}

	public List<Integer> getOutputList() {
		return outputList;
	}

	public void setOutputList(List<Integer> outputList) {
		this.outputList = outputList;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	

}
