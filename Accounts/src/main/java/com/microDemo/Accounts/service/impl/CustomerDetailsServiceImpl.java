package com.microDemo.Accounts.service.impl;

import com.microDemo.Accounts.client.CardsFeignClient;
import com.microDemo.Accounts.client.LoansFeignClient;
import com.microDemo.Accounts.dto.CardsRemoteDto;
import com.microDemo.Accounts.dto.CustomerDetailsDto;
import com.microDemo.Accounts.dto.CustomerDto;
import com.microDemo.Accounts.dto.LoansRemoteDto;
import com.microDemo.Accounts.service.IAccountsService;
import com.microDemo.Accounts.service.ICustomerDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerDetailsServiceImpl implements ICustomerDetailsService {

	private final IAccountsService accountsService;
	private final LoansFeignClient loansFeignClient;
	private final CardsFeignClient cardsFeignClient;

	@Override
	public CustomerDetailsDto getCustomerDetails(String mobileNumber) {
		CustomerDto customer = accountsService.fetchAccount(mobileNumber);
		LoansRemoteDto loan = loansFeignClient.fetchLoanDetails(mobileNumber);
		CardsRemoteDto card = cardsFeignClient.fetchCardDetails(mobileNumber);
		return new CustomerDetailsDto(customer, loan, card);
	}
}
