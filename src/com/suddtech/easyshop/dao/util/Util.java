package com.suddtech.easyshop.dao.util;

public class Util {

	public static String getPriceInDollars(int priceInCents) {
		int dollars = priceInCents / 100;
		int cents = priceInCents % 100;
		return "$" + dollars + "." +
			(String.valueOf(cents) + "0").substring(0, 2);
	}
	

	public static String getPriceInEuro(int priceInCents) {
		int euros = priceInCents / 100;
		int cents = priceInCents % 100;
		return "€" + euros + "." +
			(String.valueOf(cents) + "0").substring(0, 2);
	}

	public static String getPriceInSSP(int priceInCents) {
		int ssp = priceInCents / 100;
		int cents = priceInCents % 100;
		return "SSP" + ssp + "." +
			(String.valueOf(cents) + "0").substring(0, 2);
	}
}
