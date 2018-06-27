package com.ming.beans;

import java.util.ArrayList;

public class ProductCart extends ArrayList<ProductUnit> {
	private static final long serialVersionUID=1L;
	public boolean add(ProductUnit productUnit) {
		super.add(productUnit);
		return true;
	}
	public boolean equals(Book book) {
		for(int i=0;i<this.size();i++) {
			if(this.get(i).getProduct().getId()==book.getId()) {
				this.get(i).setCount(this.get(i).getCount()+1);
				return true;
			}
		}
		return false;
	}
	public boolean delete(int id) {
		for(int i=0;i<this.size();i++) {
			if(this.get(i).getProduct().getId()==id) {
				super.remove(i);
			}
		}
		return true;
	}
	public double getTotalCost() {
		double totalCost = 0;
		for (int i = 0; i < this.size(); i++) {
			totalCost = totalCost + this.get(i).getTotalCost();
		}
		return totalCost;
	}
}
