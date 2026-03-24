package com.microDemo.Accounts.client;

import com.microDemo.Accounts.dto.LoansRemoteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "loans")
public interface LoansFeignClient {

	@GetMapping(value = "/api/fetch")
	LoansRemoteDto fetchLoanDetails(@RequestParam("mobileNumber") String mobileNumber);
}
