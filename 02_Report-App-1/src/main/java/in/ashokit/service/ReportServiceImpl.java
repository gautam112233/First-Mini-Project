package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repositories.CitizenRepo;
import in.ashokit.request.SearchRequest;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	 private CitizenRepo repo;
	
	@Override
	public List<String> getPlanName() {
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search (SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		
		if(null !=request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
			
		}
	
			
		return repo.findAll();
	 
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}
 
	@Override
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

}
