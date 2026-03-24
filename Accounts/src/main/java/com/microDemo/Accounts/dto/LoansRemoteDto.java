package com.microDemo.Accounts.dto;

import lombok.Data;

/**
 * JSON shape returned by the Loans service {@code /api/fetch}.
 */
@Data
public class LoansRemoteDto {

	private String mobileNumber;
	private String loanNumber;
	private String loanType;
	private int totalLoan;
	private int amountPaid;
	private int outstandingAmount;
}
