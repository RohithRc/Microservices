package com.microDemo.Accounts.dto;

import lombok.Data;

/**
 * JSON shape returned by the Cards service {@code /api/fetch}.
 */
@Data
public class CardsRemoteDto {

	private String mobileNumber;
	private String cardNumber;
	private String cardType;
	private int totalLimit;
	private int amountUsed;
	private int availableAmount;
}
