package co.grandcircus.capstone6.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.capstone6.Entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByNameIgnoreCase(String name);
	
	Optional<User> findById(Long id);
}
