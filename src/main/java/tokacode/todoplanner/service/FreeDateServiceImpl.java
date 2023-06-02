package tokacode.todoplanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tokacode.todoplanner.model.FreeDate;
import tokacode.todoplanner.repository.FreeDateRepository;

@Service
public class FreeDateServiceImpl implements FreeDateService {

	@Autowired
	private FreeDateRepository freeDateRepository;
	
	@Override
	public void saveFreeDate(List<FreeDate> freeDate) {
		freeDateRepository.saveAll(freeDate);
	}

	@Override
	public List<FreeDate> getAllFreeDates() {
		return freeDateRepository.findAll();
	}

	@Override
	public void deleteAllFreeDates() {
		freeDateRepository.deleteAll();
	}

}
