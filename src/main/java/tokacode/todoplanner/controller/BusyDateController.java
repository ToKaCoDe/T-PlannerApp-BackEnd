package tokacode.todoplanner.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tokacode.todoplanner.engine.Logic;
import tokacode.todoplanner.model.AppResponse;
import tokacode.todoplanner.model.BusyDate;
import tokacode.todoplanner.model.MainInfo;
import tokacode.todoplanner.service.BusyDateService;

@RestController
@RequestMapping("/busyDate")
@CrossOrigin
public class BusyDateController {

	String answer;
	Long hoursperday;
	
	
	@Autowired
	private BusyDateService busyDateService;

	@PostMapping("/add")
	public String add(@RequestBody BusyDate busydate) {
		busyDateService.saveBusyDate(busydate);
		return "New busy date info is added - Back end";
	}

	@GetMapping("/getAll")
	public List<BusyDate> getAllBusyDates() {
		return busyDateService.getAllBusyDates();
	}

	@DeleteMapping("/deleteAll")
	public void deleteAllBusyDates() {
		busyDateService.deleteAllBusyDates();
	}

	@PostMapping("/submit")
	public void submit(@RequestBody MainInfo maininfo) {

		Logic logic = new Logic();

		logic.startdate = LocalDate.parse(maininfo.getStartdate());
		logic.scope = Integer.parseInt(maininfo.getScope());
		logic.deadline = LocalDate.parse(maininfo.getDeadline());

		logic.busyDays = busyDateService.getAllBusydatesBetween(logic.startdate, logic.deadline);
		
		hoursperday = logic.getAverageHours();
		answer = logic.isTaskDone();
		
	}

	
	  @GetMapping("/concl") 
	  public AppResponse giveConclusion() {
	  
	 
	  return new AppResponse(answer, hoursperday);
	  }
	  
	 

}
