package opensourceselfdevelopment.btsApi.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import opensourceselfdevelopment.btsApi.entities.concretes.Expo;

public interface ExpoDao extends JpaRepository<Expo,Integer>{
	
	@Query("From Expo where name=:name")
	Expo getByExpoName(String name);
	
	List<Expo> getByNameStartsWith(String name);

}
