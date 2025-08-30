package com.excelr.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="SpringBootAppFirstRestController-1",url="http://localhost:8888")
public interface FirstDetailsApiClient {

	@GetMapping("/first")
	public String invokeMethodFromFirst();
}
