package kodlamaIo.devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIo.devs.businnes.abstracts.TechnologyLanguageService;
import kodlamaIo.devs.businnes.requests.technologylanguagerequests.CreateTechnologyLanguageRequest;
import kodlamaIo.devs.businnes.requests.technologylanguagerequests.DeleteTechnologyLanguageRequest;
import kodlamaIo.devs.businnes.requests.technologylanguagerequests.UpdateTechnologyLanguageRequest;
import kodlamaIo.devs.businnes.responses.technologylanguageresponse.GetAllTechnologyResponse;
import kodlamaIo.devs.businnes.responses.technologylanguageresponse.GetTechnologyLanguageById;
import kodlamaIo.devs.core.utilities.results.DataResult;
import kodlamaIo.devs.core.utilities.results.Result;


@RestController
@RequestMapping("/api/technologieslanguage")
public class TechnologiesLanguageController {
	
	@Autowired
	private TechnologyLanguageService  technologyLanguageService;
	
	
	@PostMapping("/add")
	public Result add( @RequestBody() CreateTechnologyLanguageRequest createTechnologyLanguageRequest) throws Exception {
		return 	this.technologyLanguageService.add(createTechnologyLanguageRequest);
		
		
		
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody() UpdateTechnologyLanguageRequest updateTechnologyLanguageRequest) throws Exception {
		return 	this.technologyLanguageService.update(updateTechnologyLanguageRequest);
		
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody()  DeleteTechnologyLanguageRequest deleteTechnologyLanguageRequest) {
	return	this.technologyLanguageService.delete(deleteTechnologyLanguageRequest);
		
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllTechnologyResponse>>  getAll(){
		
	return	this.technologyLanguageService.getAll();
	}
	
	@GetMapping("/findById")
	public DataResult<GetTechnologyLanguageById>  findById(@RequestParam() int id) {
		
		return this.technologyLanguageService.findById(id);
	}
	

}
