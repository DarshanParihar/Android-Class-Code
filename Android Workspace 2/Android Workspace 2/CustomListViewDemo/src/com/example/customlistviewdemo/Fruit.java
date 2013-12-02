package com.example.customlistviewdemo;

public class Fruit {
	private String fruitName;
	private int fruitColor;
	private double fruitPrice;

	public Fruit(String fruitName, int fruitColor, double fruitPrice) {
		this.fruitName = fruitName;
		this.fruitColor = fruitColor;
		this.fruitPrice = fruitPrice;
	}

	public String getFruitName() {
		return fruitName;
	}

	public int getFruitColor() {
		return fruitColor;
	}

	public double getFruitPrice() {
		return fruitPrice;
	}

}
