package com.suddtech.easyshop.dto;

import java.math.BigDecimal;

public class WebItem implements Item{
	private String articleNo;
	private BigDecimal quantity;
	private BigDecimal price;
	
	public WebItem(String articleNo, BigDecimal price, BigDecimal quantity) {
		this.articleNo = articleNo;
		this.price = price;
		this.quantity = quantity;
	}
	
	public WebItem(Item item, BigDecimal quantity) {
		this.articleNo = item.getArticleNo();
		this.price = item.getPrice();
		this.quantity = quantity;
	}

	public String getArticleNo() {
		return articleNo;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}


}
