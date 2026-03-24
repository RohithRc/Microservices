package com.microDemo.Accounts.service;

import com.microDemo.Accounts.dto.CustomerDetailsDto;

public interface ICustomerDetailsService {

	CustomerDetailsDto getCustomerDetails(String mobileNumber);
}
