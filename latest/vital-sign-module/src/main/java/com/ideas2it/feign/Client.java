package com.ideas2it.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.dto.PatientDto;

@FeignClient(url="${patient.service.url}",name="${patient.service.name}")
public interface Client {
    @GetMapping("/id")
    public PatientDto searchById(@RequestParam("id") long id);
   
}
