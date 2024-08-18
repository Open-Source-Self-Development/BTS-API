package opensourceselfdevelopment.btsApi.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import opensourceselfdevelopment.btsApi.entities.concretes.ExpoStock;

public interface ExpoStockDao extends JpaRepository<ExpoStock,Integer> {

	List<ExpoStock> getByQuantityAndExpoId(int quantity,int expoId);
	
}
