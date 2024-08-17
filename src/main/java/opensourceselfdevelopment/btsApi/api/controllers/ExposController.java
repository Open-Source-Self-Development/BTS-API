package opensourceselfdevelopment.btsApi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import opensourceselfdevelopment.btsApi.business.abstracts.ExpoService;
import opensourceselfdevelopment.btsApi.core.utilities.results.DataResult;
import opensourceselfdevelopment.btsApi.core.utilities.results.Result;
import opensourceselfdevelopment.btsApi.entities.concretes.Expo;

@RestController
@RequestMapping("/api/expos")
public class ExposController {

	private ExpoService expoService;

	@Autowired
	public ExposController(ExpoService expoService) {
		super();
		this.expoService = expoService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Expo>> getAll(){
		return expoService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Expo expo) {
		return this.expoService.add(expo);
	}
	
	@GetMapping("/getByExpoName")
	public DataResult<Expo> getByExpoName(@RequestParam String name){
		return this.expoService.getByExpoName(name);
	}
	
	@GetMapping("/getByExpoNameStartsWith")
	public DataResult<List<Expo>> getByExpoNameStartsWith(@RequestParam String expoName){
		return this.expoService.getByNameStartsWith(expoName);
	}
	
}
