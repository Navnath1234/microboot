package com.AAA.BBB.PracticeSSSSSS;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/employees")
public class HystrixControllerClass {

	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value = "/ddd")
	@HystrixCommand(fallbackMethod="display")
	public String getProductList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);

		return restTemplate.exchange("http://localhost:8092/employees", HttpMethod.GET, entity, String.class).getBody();
	}
	
	public String display()
	
	{
		
		return "service is down";
	}
	
	@RequestMapping(value = "/ddd" , method = RequestMethod.POST)
	@HystrixCommand(fallbackMethod="failed")
	  public String createProducts(@RequestBody Employee employee) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Employee> entity = new HttpEntity<Employee>(employee,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8092/employees", HttpMethod.POST, entity, String.class).getBody();
	   }

	public String failed(Employee employee)
	
	{
	
		return "service is down...please try after some time";
	
	}
	
	
	   @RequestMapping(value = "/ddd/{id}", method = RequestMethod.PUT)
	   @HystrixCommand(fallbackMethod="Display1")
	   public String updateProduct(@PathVariable("id") String id, @RequestBody Employee employee) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Employee> entity = new HttpEntity<Employee>(employee,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8092/employees/"+id, HttpMethod.PUT, entity, String.class).getBody();
	   }
		public String Display1(String id, Employee employee)
		
		{
		
			return "service has some problem...please try after some time";
		
		}
		
		 @RequestMapping(value = "/ddd/{id}", method = RequestMethod.DELETE)
		 @HystrixCommand(fallbackMethod="failed2")
		   public String deleteProduct(@PathVariable("id") String id) {
		      HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);
		      
		      return restTemplate.exchange(
		         "http://localhost:8093/employees/"+id, HttpMethod.DELETE, entity, String.class).getBody();
		   }
		
			public String failed2(String id)
			
			{
			
				return "service is down...please try after some time";
			
			}
			
		
	}





