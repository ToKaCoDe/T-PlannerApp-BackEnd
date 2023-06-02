package tokacode.todoplanner.service;

import java.util.List;

import tokacode.todoplanner.model.FreeDate;

public interface FreeDateService {

	public void saveFreeDate(List<FreeDate> freeDate);
	
	public List<FreeDate> getAllFreeDates();
	
	public void deleteAllFreeDates();
}
