package in.ashokit.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repositories.CitizenRepo;
import in.ashokit.request.SearchRequest;
import in.ashokit.util.EmailUtils;
import in.ashokit.util.ExcelGenerator;
import in.ashokit.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private CitizenRepo repo;
	@Autowired
	private ExcelGenerator excelGenerator;
	@Autowired
	private PdfGenerator pdfGenerator;
	@Autowired
	private EmailUtils emailUtils;
	
	
	@Override
	public List<String> getPlanName() {
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {

		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();

		if (null != request.getPlanName() && ! "".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}

		if (null != request.getPlanStatus() && ! "".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		if (null != request.getGender() && ! "".equals(request.getGender() )) {
			entity.setGender (request.getGender() );
		}
		
		if (null != request.getPlanStartDate() && ! "".equals(request.getPlanStartDate() )) {
			String PlanStartDate =request.getPlanStartDate();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate=LocalDate.parse(PlanStartDate,formatter);
			entity.setPlanStartDate(localDate);
		}
		
		
		if (null != request.getPlanEndDate()&& ! "".equals(request.getPlanEndDate() )) {
			String PlanEndDate =request.getPlanEndDate();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate=LocalDate.parse(PlanEndDate,formatter);
			entity.setPlanEndDate(localDate);
		}
		
		
	   // return repo.findAll();
		
	    return repo.findAll(Example.of(entity));

	}
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		List<CitizenPlan> plans = repo.findAll();
		
		File f = new File("Plans.pdf");
		
		pdfGenerator.generator(response, plans,f);
		
		String subject="Testmail subject";
		String body="<h1>Test male body </h1>";
		String to="rajukumar59210@gmail.com";
		emailUtils.sendEmail(subject, body, to,f);
		return true;
	}
	
	

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		
		File f = new File("Plans.xls");
		List<CitizenPlan> plans = repo.findAll();
		excelGenerator.generator(response, plans,f);
		
		String subject="Testmail subject";
		String body="<h1>Test male body </h1>";
		String to="rajukumar59210@gmail.com";
		emailUtils.sendEmail(subject, body, to,f);
		
		return true;
	}

}
