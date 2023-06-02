package tokacode.todoplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tokacode.todoplanner.model.FreeDate;

@Repository
public interface FreeDateRepository extends JpaRepository<FreeDate, Integer> {

}
