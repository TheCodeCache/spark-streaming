package com.stream.test.sparksqs;

public class BNode {

	int value;
	BNode left;
	BNode right;

	public BNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
