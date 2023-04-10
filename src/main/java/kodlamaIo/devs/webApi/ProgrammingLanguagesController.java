package kodlamaIo.devs.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIo.devs.businnes.abstracts.ProgrammingLanguageService;
import kodlamaIo.devs.businnes.requests.programminglanguagerequests.CreateProgrammingLanguageRequest;
import kodlamaIo.devs.businnes.requests.programminglanguagerequests.DeleteProgrammingLanguageRequest;
import kodlamaIo.devs.businnes.requests.programminglanguagerequests.UpdateProgrammingLanguageRequest;
import kodlamaIo.devs.businnes.responses.programminglanguageresponse.GetAllProgrammingLanguageResponse;
import kodlamaIo.devs.businnes.responses.programminglanguageresponse.GetProgrammingLanguageById;
import kodlamaIo.devs.core.utilities.results.DataResult;
import kodlamaIo.devs.core.utilities.results.Result;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@PostMapping("/add")
	public Result add( @RequestBody() CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		
	return	this.programmingLanguageService.add(createProgrammingLanguageRequest);
		
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllProgrammingLanguageResponse>> getAll() {
		
		return this.programmingLanguageService.getAll();
	}
	
	@PutMapping("/update")
	public Result update( @RequestBody() UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
	return	this.programmingLanguageService.update(updateProgrammingLanguageRequest);
	}
	
	
	@DeleteMapping("/delete")
	public Result delette(@RequestBody()  DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		return this.programmingLanguageService.delete(deleteProgrammingLanguageRequest);
	}
	
	@GetMapping("/getById")
	public DataResult<GetProgrammingLanguageById> findById(@RequestParam() int id) {
		
		return this.programmingLanguageService.findById(id);
	
	}

}
