package kodlamaIo.devs.businnes.abstracts;

import kodlamaIo.devs.core.entities.User;
import kodlamaIo.devs.core.utilities.results.DataResult;
import kodlamaIo.devs.core.utilities.results.Result;

public interface UserService {
	
	Result add(User user);
	
	DataResult<User>  findByEmail(String email);

}
