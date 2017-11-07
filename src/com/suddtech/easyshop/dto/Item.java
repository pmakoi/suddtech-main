package com.suddtech.easyshop.dto;

import java.math.BigDecimal;

public interface Item {
String getArticleNo();
	
	BigDecimal getPrice();
	
	BigDecimal getQuantity();
}
