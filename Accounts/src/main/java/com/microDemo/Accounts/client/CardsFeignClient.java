package com.microDemo.Accounts.client;

import com.microDemo.Accounts.dto.CardsRemoteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards")
public interface CardsFeignClient {

	@GetMapping(value = "/api/fetch")
	CardsRemoteDto fetchCardDetails(@RequestParam("mobileNumber") String mobileNumber);
}
