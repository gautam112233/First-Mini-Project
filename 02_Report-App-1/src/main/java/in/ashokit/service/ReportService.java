package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.request.SearchRequest;

@Service
public interface ReportService {
	
	public List<String > getPlanName();
	
	public List <String> getPlanStatus();
	
	public List<CitizenPlan> search (SearchRequest request );
	
	public boolean exportPdf();
	
	public boolean exportExcel();
}
