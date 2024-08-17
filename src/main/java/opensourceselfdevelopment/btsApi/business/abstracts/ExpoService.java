package opensourceselfdevelopment.btsApi.business.abstracts;

import java.util.List;

import opensourceselfdevelopment.btsApi.core.utilities.results.DataResult;
import opensourceselfdevelopment.btsApi.core.utilities.results.Result;
import opensourceselfdevelopment.btsApi.entities.concretes.Expo;

public interface ExpoService {

	DataResult<List<Expo>> getAll();
	Result add(Expo expo);
	DataResult<Expo> getByExpoName(String expoName);
	DataResult<List<Expo>> getByNameStartsWith(String name);
	
//	Result update(Expo expo);
//	Result delete(Integer id);
}
