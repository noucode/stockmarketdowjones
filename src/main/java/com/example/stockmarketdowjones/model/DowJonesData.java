package com.example.stockmarketdowjones.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name="dow_jones_index_data")
@IdClass(ComposedId.class)
public class DowJonesData implements Serializable {
	private static final long serialVersionUID = 1L;	

	@Id
	@Column(name = "quarter")
    private String quarter;  
    
    @Id
	@Column(name = "stock")
    private String stock;
    
    @Id
	@Column(name = "date")
    private String date;  
    
	@Column(name = "open")
    private String open;
	
	@Column(name = "high")
    private String high;
	
	@Column(name = "low")
    private String low;
	
	@Column(name = "close")
    private String close;
    
	@Column(name = "volume")
    private String volume;
	
	@Column(name = "percent_change_price")
    private String percent_change_price;
    
	@Column(name = "percent_change_volume_over_last_wk")
    private String percent_change_volume_over_last_wk;
    
	@Column(name = "previous_weeks_volume")
    private String previous_weeks_volume;
	
	@Column(name = "next_weeks_open")
    private String next_weeks_open;
    
	@Column(name = "next_weeks_close")
    private String next_weeks_close;
    
	@Column(name = "percent_change_next_weeks_price")
    private String percent_change_next_weeks_price;
    
	@Column(name = "days_to_next_dividend")
    private String days_to_next_dividend;
    
	@Column(name = "percent_return_next_dividend")
    private String percent_return_next_dividend;
	
	
	public DowJonesData() {		
	}
	
	public DowJonesData(String quarter, String stock, String date, String open, String high, String low, String close,
			String volume, String percent_change_price, String percent_change_volume_over_last_wk,
			String previous_weeks_volume, String next_weeks_open, String next_weeks_close,
			String percent_change_next_weeks_price, String days_to_next_dividend, String percent_return_next_dividend) {
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.percent_change_price = percent_change_price;
		this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
		this.previous_weeks_volume = previous_weeks_volume;
		this.next_weeks_open = next_weeks_open;
		this.next_weeks_close = next_weeks_close;
		this.percent_change_next_weeks_price = percent_change_next_weeks_price;
		this.days_to_next_dividend = days_to_next_dividend;
		this.percent_return_next_dividend = percent_return_next_dividend;
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

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPercent_change_price() {
		return percent_change_price;
	}

	public void setPercent_change_price(String percent_change_price) {
		this.percent_change_price = percent_change_price;
	}

	public String getPercent_change_volume_over_last_wk() {
		return percent_change_volume_over_last_wk;
	}

	public void setPercent_change_volume_over_last_wk(String percent_change_volume_over_last_wk) {
		this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
	}

	public String getPrevious_weeks_volume() {
		return previous_weeks_volume;
	}

	public void setPrevious_weeks_volume(String previous_weeks_volume) {
		this.previous_weeks_volume = previous_weeks_volume;
	}

	public String getNext_weeks_open() {
		return next_weeks_open;
	}

	public void setNext_weeks_open(String next_weeks_open) {
		this.next_weeks_open = next_weeks_open;
	}

	public String getNext_weeks_close() {
		return next_weeks_close;
	}

	public void setNext_weeks_close(String next_weeks_close) {
		this.next_weeks_close = next_weeks_close;
	}

	public String getPercent_change_next_weeks_price() {
		return percent_change_next_weeks_price;
	}

	public void setPercent_change_next_weeks_price(String percent_change_next_weeks_price) {
		this.percent_change_next_weeks_price = percent_change_next_weeks_price;
	}

	public String getDays_to_next_dividend() {
		return days_to_next_dividend;
	}

	public void setDays_to_next_dividend(String days_to_next_dividend) {
		this.days_to_next_dividend = days_to_next_dividend;
	}

	public String getPercent_return_next_dividend() {
		return percent_return_next_dividend;
	}

	public void setPercent_return_next_dividend(String percent_return_next_dividend) {
		this.percent_return_next_dividend = percent_return_next_dividend;
	}

	@Override
	public String toString() {
		return "DowJonesData [quarter=" + quarter + ", stock=" + stock + ", date=" + date + ", open=" + open + ", high="
				+ high + ", low=" + low + ", close=" + close + ", volume=" + volume + "]";
	}
	
}









