package com.example.stockmarketdowjones.model;

import java.io.Serializable;


public class ComposedId implements Serializable {
	private static final long serialVersionUID = 1L;	

	private String quarter;  
    private String stock;
    private String date;
    
	public ComposedId() {
	}  
    
	public ComposedId(String quarter, String stock, String date) {
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}  

    
}


