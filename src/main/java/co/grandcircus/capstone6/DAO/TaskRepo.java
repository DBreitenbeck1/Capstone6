package co.grandcircus.capstone6.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.capstone6.Entities.Task;
import co.grandcircus.capstone6.Entities.User;


public interface TaskRepo extends JpaRepository<Task, Long> {

	Task findByUser(Long userId); 
	//User findByNameIgnoreCase(String name);

}
