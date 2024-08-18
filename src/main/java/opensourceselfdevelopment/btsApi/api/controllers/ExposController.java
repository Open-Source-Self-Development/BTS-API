package opensourceselfdevelopment.btsApi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import opensourceselfdevelopment.btsApi.business.abstracts.ExpoService;
import opensourceselfdevelopment.btsApi.business.requests.CreateExpoRequest;
import opensourceselfdevelopment.btsApi.business.requests.UpdateExpoRequest;
import opensourceselfdevelopment.btsApi.business.responses.GetAllExposResponse;
import opensourceselfdevelopment.btsApi.business.responses.GetByIdExpoResponse;
import opensourceselfdevelopment.btsApi.core.utilities.results.DataResult;
import opensourceselfdevelopment.btsApi.core.utilities.results.Result;
import opensourceselfdevelopment.btsApi.entities.concretes.Expo;
import opensourceselfdevelopment.btsApi.entities.dtos.ExpoWithExpoStockDto;

@RestController
@RequestMapping("/api/expos")
public class ExposController {

	private ExpoService expoService;

	@Autowired
	public ExposController(ExpoService expoService) {
		this.expoService = expoService;
	}
	
	@GetMapping()
	public DataResult<List<GetAllExposResponse>> getAll(){
		return expoService.getAll();
		
	}
	
	@PostMapping()
	public Result add(@RequestBody @Valid() CreateExpoRequest createExpoRequest) {
		return this.expoService.add(createExpoRequest);
	}
	
	@GetMapping("/getByExpoName")
	public DataResult<Expo> getByExpoName(@RequestParam String name){
		return this.expoService.getByExpoName(name);
	}
	
	@GetMapping("/getByExpoNameStartsWith")
	public DataResult<List<Expo>> getByExpoNameStartsWith(@RequestParam String expoName){
		return this.expoService.getByNameStartsWith(expoName);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Expo>> getAll(int pageNo, int pageSize){
		return expoService.getAll(pageNo,pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Expo>> getAllSorted() {
		return expoService.getAllSorted();
	}
	
	@GetMapping("/getExpoWithStock")
	public DataResult<List<ExpoWithExpoStockDto>> getExpoWithStock(){
		return expoService.getExpoWithStock();
		
	}
	
	@GetMapping("/{id}")
	public DataResult<GetByIdExpoResponse> getById(@PathVariable int id){
		return this.expoService.getById(id);
	} 
	
	@PutMapping
	public Result update(@RequestBody UpdateExpoRequest updateExpoRequest) {
		return this.expoService.update(updateExpoRequest);
	} 
	
}
