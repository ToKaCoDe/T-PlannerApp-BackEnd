package tokacode.todoplanner.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tokacode.todoplanner.model.BusyDate;

@Repository
public interface BusyDateRepository extends JpaRepository<BusyDate, Integer> {
	List<BusyDate> findByBusydateBetween(LocalDate startdate, LocalDate enddate);
}
