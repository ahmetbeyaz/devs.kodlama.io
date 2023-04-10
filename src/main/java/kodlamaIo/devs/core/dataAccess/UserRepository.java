package kodlamaIo.devs.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaIo.devs.core.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
	

}
