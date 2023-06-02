package tokacode.todoplanner.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tokacode.todoplanner.model.BusyDate;
import tokacode.todoplanner.repository.BusyDateRepository;

@Service
public class BusyDateServiceImpl implements BusyDateService {

	@Autowired
	private BusyDateRepository busyDateRepository;

	@Override
	public BusyDate saveBusyDate(BusyDate busydate) {
		return busyDateRepository.save(busydate);
	}

	@Override
	public List<BusyDate> getAllBusyDates() {
		return busyDateRepository.findAll();
	}

	@Override
	public void deleteAllBusyDates() {
		busyDateRepository.deleteAll();
	}

	@Override
	public List<BusyDate> getAllBusydatesBetween(LocalDate startdate, LocalDate enddate) {
		return busyDateRepository.findByBusydateBetween(startdate, enddate);
	}

}
