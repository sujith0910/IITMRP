package com.learn.feign1.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
 
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learn.feign1.model.Passenger;
@FeignClient(value = "instantwebtools-api", url = "https://api.instantwebtools.net/v1/")
public interface PassengerClient {
    @RequestMapping(method = RequestMethod.GET, value = "/passenger")
    List<Passenger> readPassengers();
    @RequestMapping(method = RequestMethod.GET, value = "/passenger/{Id}")
    Passenger readPassengerById(@PathVariable("Id") String passengerId);
}
