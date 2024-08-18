package opensourceselfdevelopment.btsApi.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import opensourceselfdevelopment.btsApi.entities.concretes.Expo;
import opensourceselfdevelopment.btsApi.entities.dtos.ExpoWithExpoStockDto;

public interface ExpoDao extends JpaRepository<Expo,Integer>{
	
	@Query("From Expo where name=:name")
	Expo getByExpoName(String name);
	
	List<Expo> getByNameStartsWith(String name);
	 
	@Query("Select new opensourceselfdevelopment.btsApi.entities.dtos.ExpoWithExpoStockDto"
			+ "(e.id,e.name,es.quantity) "
			+ "From Expo e Inner Join e.expoStocks es")
	List<ExpoWithExpoStockDto> getExpoWithStock();
	
	boolean existsByName(String name);
	
		
}
