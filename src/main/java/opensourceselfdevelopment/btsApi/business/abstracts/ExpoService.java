package opensourceselfdevelopment.btsApi.business.abstracts;

import java.util.List;

import opensourceselfdevelopment.btsApi.business.requests.CreateExpoRequest;
import opensourceselfdevelopment.btsApi.business.requests.UpdateExpoRequest;
import opensourceselfdevelopment.btsApi.business.responses.GetAllExposResponse;
import opensourceselfdevelopment.btsApi.business.responses.GetByIdExpoResponse;
import opensourceselfdevelopment.btsApi.core.utilities.results.DataResult;
import opensourceselfdevelopment.btsApi.core.utilities.results.Result;
import opensourceselfdevelopment.btsApi.entities.concretes.Expo;
import opensourceselfdevelopment.btsApi.entities.dtos.ExpoWithExpoStockDto;

public interface ExpoService {

	DataResult<List<GetAllExposResponse>> getAll();
	DataResult<GetByIdExpoResponse> getById(int id);

	DataResult<List<Expo>> getAll(int pageNo, int pageSize);
	DataResult<List<Expo>> getAllSorted();

	Result add(CreateExpoRequest createExpoRequest);
	Result update(UpdateExpoRequest updateExpoRequest);

	DataResult<Expo> getByExpoName(String expoName);
	DataResult<List<Expo>> getByNameStartsWith(String name);
	DataResult<List<ExpoWithExpoStockDto>> getExpoWithStock();

}
