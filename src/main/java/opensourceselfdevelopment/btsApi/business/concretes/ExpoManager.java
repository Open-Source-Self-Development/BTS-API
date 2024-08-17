package opensourceselfdevelopment.btsApi.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import opensourceselfdevelopment.btsApi.business.abstracts.ExpoService;
import opensourceselfdevelopment.btsApi.core.utilities.results.DataResult;
import opensourceselfdevelopment.btsApi.core.utilities.results.Result;
import opensourceselfdevelopment.btsApi.core.utilities.results.SuccessDataResult;
import opensourceselfdevelopment.btsApi.core.utilities.results.SuccessResult;
import opensourceselfdevelopment.btsApi.dataAccess.abstracts.ExpoDao;
import opensourceselfdevelopment.btsApi.entities.concretes.Expo;

@Service
public class ExpoManager implements ExpoService{

	private ExpoDao expoDao;
	
	@Autowired
	public ExpoManager(ExpoDao expoDao) {
		super();
		this.expoDao = expoDao;
	}


	@Override
	public DataResult<List<Expo>> getAll() {
		return new SuccessDataResult<List<Expo>>
		(this.expoDao.findAll(),"Data geldi");

	}


	@Override
	public Result add(Expo expo) {
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




//	@Override
//	public Result update(Expo expo) {
//		
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public Result delete(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
