package tokacode.todoplanner.service;

import java.time.LocalDate;
import java.util.List;

import tokacode.todoplanner.model.BusyDate;

public interface BusyDateService {

	public BusyDate saveBusyDate(BusyDate busydate);

	public List<BusyDate> getAllBusyDates();
	
	public void deleteAllBusyDates();
	
	public List<BusyDate> getAllBusydatesBetween(LocalDate startDate, LocalDate endDate);

}
