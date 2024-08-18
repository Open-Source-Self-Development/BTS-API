package opensourceselfdevelopment.btsApi.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import opensourceselfdevelopment.btsApi.core.utilities.exceptions.BusinessException;
import opensourceselfdevelopment.btsApi.dataAccess.abstracts.ExpoDao;

@AllArgsConstructor
@Service
public class ExpoBusinessRules {
	
	private ExpoDao expoDao;
	
	public void checkIfExpoNameExists(String name) {
		if(this.expoDao.existsByName(name)) {
			throw new BusinessException("Expo name already exists");
		}
		
	}

}
