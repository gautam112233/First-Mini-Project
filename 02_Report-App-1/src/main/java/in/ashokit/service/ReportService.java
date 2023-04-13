package in.ashokit.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.request.SearchRequest;

@Service
public interface ReportService {
	
	public List<String > getPlanName();
	
	public List <String> getPlanStatus();
	
	public List<CitizenPlan> search (SearchRequest request );
	
	public boolean exportPdf(HttpServletResponse response) throws Exception ;
	
	public boolean exportExcel(HttpServletResponse response) throws Exception ;
}
