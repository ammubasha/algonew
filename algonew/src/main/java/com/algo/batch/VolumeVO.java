package com.algo.batch;

public class VolumeVO {
	
	
		String stockSymbol;
		String stockDesc;
		String stockvolume;
		
		public VolumeVO() {
			
		}
		
		public VolumeVO(String symbol,String desc,String vol) {
			this.stockSymbol = symbol;
			this.stockDesc = desc;
			this.stockvolume = vol;
			
			
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

		public String getStockvolume() {
			return stockvolume;
		}

		public void setStockvolume(String stockvolume) {
			this.stockvolume = stockvolume;
		}

		
		

	}



