											package in.ashokit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repositories.CitizenRepo;


@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		repo.deleteAll();
		
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("jay Bhaiya");
		c1.setGender("male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Aprove");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmt(12000.00);

		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Shayam");
		c2.setGender("male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenaialReason("rental income");

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Sree");
		c3.setGender("female");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().plusMonths(6));
		c3.setPlanEndDate(LocalDate.now().plusMonths(4));
		c3.setBenifitAmt(12000.00);
		c3.setTerminition(LocalDate.now());
		c3.setTerminitionReasion("employee");

		// FOOD
		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("siva");
		c4.setGender("male");
		c4.setPlanName("food");
		c4.setPlanStatus("Aprove");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenifitAmt(10000.00);

		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Sanjeev");
		c5.setGender("male");
		c5.setPlanName("food");
		c5.setPlanStatus("Denied");
		c5.setDenaialReason("job income");

		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Sree ram");
		c6.setGender("female");
		c6.setPlanName("food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().plusMonths(6));
		c6.setPlanEndDate(LocalDate.now().plusMonths(4));
		c6.setBenifitAmt(15000.00);
		c6.setTerminition(LocalDate.now());
		c6.setTerminitionReasion("employee");

		// Medical
		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("jay");
		c7.setGender("male");
		c7.setPlanName("medical");
		c7.setPlanStatus("Aprove");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenifitAmt(12000.00);

		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("Shayam");
		c8.setGender("male");
		c8.setPlanName("medical");
		c8.setPlanStatus("Denied");
		c8.setDenaialReason("rental income");

		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Sree");
		c9.setGender("female");
		c9.setPlanName("medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().plusMonths(6));
		c9.setPlanEndDate(LocalDate.now().plusMonths(4));
		c9.setBenifitAmt(12000.00);
		c9.setTerminition(LocalDate.now());
		c9.setTerminitionReasion("employee");

		// employeement
		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("jay Shankar");
		c10.setGender("male");
		c10.setPlanName("employeement");
		c10.setPlanStatus("Aprove");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenifitAmt(18000.00);

		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("brajesh");
		c11.setGender("male");
		c11.setPlanName("employeement");
		c11.setPlanStatus("Denied");
		c11.setDenaialReason("bussenes");

		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("sony");
		c12.setGender("female");
		c12.setPlanName("employeement");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().plusMonths(6));
		c12.setPlanEndDate(LocalDate.now().plusMonths(4));
		c12.setBenifitAmt(32000.00);
		c12.setTerminition(LocalDate.now());
		c12.setTerminitionReasion("employee");

		List<CitizenPlan> list = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);

		repo.saveAll(list);
	}

}
