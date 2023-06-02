package tokacode.todoplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tokacode.todoplanner.model.FreeDate;
import tokacode.todoplanner.service.FreeDateService;

@RestController
@RequestMapping("/freeDate")
@CrossOrigin
public class FreeDateController {

	@Autowired
	private FreeDateService freeDateService;
	
	@GetMapping("/getFreeAll")
	public List<FreeDate> getAllFreeDates() {
		return freeDateService.getAllFreeDates();
	}
}
