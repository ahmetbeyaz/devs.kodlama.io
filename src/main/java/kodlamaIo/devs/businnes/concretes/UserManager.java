package kodlamaIo.devs.businnes.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIo.devs.businnes.abstracts.UserService;
import kodlamaIo.devs.core.dataAccess.UserRepository;
import kodlamaIo.devs.core.entities.User;
import kodlamaIo.devs.core.utilities.results.DataResult;
import kodlamaIo.devs.core.utilities.results.Result;
import kodlamaIo.devs.core.utilities.results.SuccessDataResult;
import kodlamaIo.devs.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Result add(User user) {
		
		this.userRepository.save(user);
		
		return new SuccessResult("User add");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		
		
		return new SuccessDataResult<User>(this.userRepository.findByEmail(email));
	}

}
