package kodlamaIo.devs.webApi;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIo.devs.businnes.abstracts.UserService;
import kodlamaIo.devs.core.entities.User;
import kodlamaIo.devs.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping(value="/api/user")
public class UsersController {
	
	
	@Autowired
	UserService userService;
	
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody() User user) {
		
		return ResponseEntity.ok(this.userService.add(user));
		
	}
	

	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException 
			exceptions){
		
		Map<String,String>  validatonErrors=new HashMap<String,String>();
		
		for( FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validatonErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
			
				
		}
		
		ErrorDataResult<Object> errors=new ErrorDataResult<>(validatonErrors,"Dogrulama Hatasi");
		return errors;
		
		
		
		
		
	}

}
