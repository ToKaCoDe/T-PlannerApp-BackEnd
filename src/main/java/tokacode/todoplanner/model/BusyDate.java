package tokacode.todoplanner.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BusyDate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate busydate;
	private int busyhours;

	public BusyDate() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getBusydate() {
		return busydate;
	}

	public void setBusydate(LocalDate busydate) {
		this.busydate = busydate;
	}

	public int getBusyhours() {
		return busyhours;
	}

	public void setBusyhours(int busyhours) {
		this.busyhours = busyhours;
	}

	

}
