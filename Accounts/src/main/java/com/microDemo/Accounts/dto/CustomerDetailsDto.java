package com.microDemo.Accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsDto {

	private CustomerDto customer;
	private LoansRemoteDto loan;
	private CardsRemoteDto card;
}
