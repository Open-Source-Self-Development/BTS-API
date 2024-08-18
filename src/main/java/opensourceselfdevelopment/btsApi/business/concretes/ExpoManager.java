package opensourceselfdevelopment.btsApi.business.concretes;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import opensourceselfdevelopment.btsApi.business.abstracts.ExpoService;
import opensourceselfdevelopment.btsApi.business.requests.CreateExpoRequest;
import opensourceselfdevelopment.btsApi.business.requests.UpdateExpoRequest;
import opensourceselfdevelopment.btsApi.business.responses.GetAllExposResponse;
import opensourceselfdevelopment.btsApi.business.responses.GetByIdExpoResponse;
import opensourceselfdevelopment.btsApi.core.utilities.mappers.ModelMapperService;
import opensourceselfdevelopment.btsApi.core.utilities.results.DataResult;
import opensourceselfdevelopment.btsApi.core.utilities.results.Result;
import opensourceselfdevelopment.btsApi.core.utilities.results.SuccessDataResult;
import opensourceselfdevelopment.btsApi.core.utilities.results.SuccessResult;
import opensourceselfdevelopment.btsApi.dataAccess.abstracts.ExpoDao;
import opensourceselfdevelopment.btsApi.entities.concretes.Expo;
import opensourceselfdevelopment.btsApi.entities.dtos.ExpoWithExpoStockDto;
import opensourceselfdevelopment.btsApi.rules.ExpoBusinessRules;

@Service
@AllArgsConstructor
public class ExpoManager implements ExpoService{

	private ExpoDao expoDao;
	private ModelMapperService modelMapperService;
	private ExpoBusinessRules expoBusinessRules;

	@Override
	public DataResult<List<GetAllExposResponse>> getAll() {
		
		List<GetAllExposResponse> exposResponse= expoDao.findAll().stream()
				.map(expo->this.modelMapperService.forResponse().map(expo, GetAllExposResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllExposResponse>>
		(exposResponse,"Data geldi");

	}


	@Override
	public Result add(CreateExpoRequest createExpoRequest) {
		this.expoBusinessRules.checkIfExpoNameExists(createExpoRequest.getName());
		
		Expo expo=this.modelMapperService.forRequest().map(createExpoRequest, Expo.class);
		this.expoDao.save(expo);
		return new SuccessResult("Kaydedildi");
	}


	@Override
	public DataResult<Expo> getByExpoName(String expoName) {
		return new SuccessDataResult<Expo>
		(this.expoDao.getByExpoName(expoName),"Data geldi");
	}


	@Override
	public DataResult<List<Expo>> getByNameStartsWith(String name) {
		return new SuccessDataResult<List<Expo>>
		(this.expoDao.getByNameStartsWith(name),"Data geldi");
	}


	@Override
	public DataResult<List<Expo>> getAll(int pageNo, int pageSize) {
		Pageable pageable =PageRequest.of(pageNo-1,pageSize);
		
		return new SuccessDataResult<List<Expo>>
		(this.expoDao.findAll(pageable).getContent());
	}


	@Override
	public DataResult<List<Expo>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"name");
		return new SuccessDataResult<List<Expo>>(this.expoDao.findAll(sort),"Başarılı");
		
	}


	@Override
	public DataResult<List<ExpoWithExpoStockDto>> getExpoWithStock() {
		return new SuccessDataResult<List<ExpoWithExpoStockDto>>
		(this.expoDao.getExpoWithStock(),"Data geldi");
	}


	@Override
	public Result update(UpdateExpoRequest updateExpoRequest) {
		Expo expo=this.modelMapperService.forRequest().map(updateExpoRequest, Expo.class);
		this.expoDao.save(expo);
		return new SuccessResult("Kaydedildi");
		
	}


	@Override
	public DataResult<GetByIdExpoResponse> getById(int id) {
		Expo expo=this.expoDao.findById(id).orElseThrow();
		GetByIdExpoResponse response=this.modelMapperService.forResponse()
				.map(expo,GetByIdExpoResponse.class);
		
		return new SuccessDataResult<GetByIdExpoResponse>
		(response,"Data geldi");
	}

}
