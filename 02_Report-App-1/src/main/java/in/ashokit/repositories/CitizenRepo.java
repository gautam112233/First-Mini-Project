package in.ashokit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.CitizenPlan;


public interface CitizenRepo extends JpaRepository<CitizenPlan, Integer>{
	
	@Query("select distinct(planName)from CitizenPlan")
		public List<String> getPlanNames();
		
		@Query("select distinct (planStatus) from CitizenPlan" )
		public List<String> getPlanStatus();
		
}
