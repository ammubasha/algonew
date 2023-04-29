package com.algo.batch;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.GregorianCalendar;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity
@Table(name = "algo_nse_vol_history")
public class VolumeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long stockId;
	String stockSymbol;
	String stockDesc;
	Integer stockvolume;
	Timestamp stocktimestamp;
	
	Random ran = new Random();
	
	public VolumeEntity() {
		
		
	}
	
	public VolumeEntity(String symbol,String desc,Integer vol) {
		this.stockSymbol = symbol;
		this.stockDesc = desc;
		this.stockvolume = vol;
		this.stocktimestamp = Timestamp.from(Instant.now());
		
	}

	public Long getStockId() {
		stockId =  GregorianCalendar.getInstance()
				.get(GregorianCalendar.DATE)+GregorianCalendar.getInstance().get(GregorianCalendar.HOUR)+GregorianCalendar.getInstance()
				.get(GregorianCalendar.MILLISECOND)+GregorianCalendar.getInstance().get(GregorianCalendar.SECOND)+ran.nextLong();

		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public String getStockDesc() {
		return stockDesc;
	}

	public void setStockDesc(String stockDesc) {
		this.stockDesc = stockDesc;
	}

	public Integer getStockvolume() {
		return stockvolume;
	}

	public void setStockvolume(Integer stockvolume) {
		this.stockvolume = stockvolume;
	}

	public Timestamp getStocktimestamp() {
		return stocktimestamp;
	}

	public void setStocktimestamp(Timestamp stocktimestamp) {
		this.stocktimestamp = stocktimestamp;
	}
	

}
