package kodlamaIo.devs.businnes.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIo.devs.businnes.abstracts.ProgrammingLanguageService;
import kodlamaIo.devs.businnes.requests.programminglanguagerequests.CreateProgrammingLanguageRequest;
import kodlamaIo.devs.businnes.requests.programminglanguagerequests.DeleteProgrammingLanguageRequest;
import kodlamaIo.devs.businnes.requests.programminglanguagerequests.UpdateProgrammingLanguageRequest;
import kodlamaIo.devs.businnes.responses.programminglanguageresponse.GetAllProgrammingLanguageResponse;
import kodlamaIo.devs.businnes.responses.programminglanguageresponse.GetProgrammingLanguageById;
import kodlamaIo.devs.core.utilities.results.DataResult;
import kodlamaIo.devs.core.utilities.results.Result;
import kodlamaIo.devs.core.utilities.results.SuccessDataResult;
import kodlamaIo.devs.core.utilities.results.SuccessResult;
import kodlamaIo.devs.dataAcces.ProgrammingLanguageRepository;
import kodlamaIo.devs.entities.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	@Autowired
	ProgrammingLanguageRepository programmingLanguageRepository;
	
	

	@Override
	public Result add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		
		if(createProgrammingLanguageRequest.getName().isBlank()||isValidNameExist(createProgrammingLanguageRequest.getName())) {
			
			throw new Exception("Isim alanı boş geçilemez");
			
		}
		
		  ProgrammingLanguage programmingLanguage=new ProgrammingLanguage();
		  programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		  
		  this.programmingLanguageRepository.save(programmingLanguage);
		  
		  return new SuccessResult("New Programming cod add");
	}



	@Override
	public DataResult<List<GetAllProgrammingLanguageResponse>> getAll() {
	
		List<ProgrammingLanguage>  programmingLanguages=programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguageResponse>  getAllProgrammingLanguageResponses=new ArrayList<>();
		
		for(ProgrammingLanguage programmingLanguage:programmingLanguages) {
			GetAllProgrammingLanguageResponse responseItem=new GetAllProgrammingLanguageResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			
			getAllProgrammingLanguageResponses.add(responseItem);
		}
		
	return new SuccessDataResult<List<GetAllProgrammingLanguageResponse>>(getAllProgrammingLanguageResponses,"Data Listelendi");
	      
	  
	   
	}



	@Override
	public Result update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		
		if(updateProgrammingLanguageRequest.getName().isBlank()||isValidNameExist(updateProgrammingLanguageRequest.getName())) {
			throw new Exception("İsim Alani bos gecilemez");
			
		}
		
		ProgrammingLanguage programmingLanguage=new ProgrammingLanguage();
		programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
		
		this.programmingLanguageRepository.save(programmingLanguage);
		
		return new SuccessResult("Cod uptaded");
		
		
	}



	@Override
	public Result delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage=new ProgrammingLanguage();
		programmingLanguage.setId(deleteProgrammingLanguageRequest.getId());
		
		this.programmingLanguageRepository.delete(programmingLanguage);
		
		return new SuccessResult("Cod deleted");		
		
	}



	@Override
	public DataResult<GetProgrammingLanguageById> findById( int id) {
		
	  ProgrammingLanguage programmingLanguage=programmingLanguageRepository.findById(id);
	  GetProgrammingLanguageById getProgrammingLanguageById=new GetProgrammingLanguageById();
	   
	   getProgrammingLanguageById.setId(programmingLanguage.getId());
	   getProgrammingLanguageById.setName(programmingLanguage.getName());
	   
	   
	   
	   return new SuccessDataResult<GetProgrammingLanguageById>(getProgrammingLanguageById,"id");
	  
	  
	  
		
	}
	
	
	
	public boolean isValidNameExist(String name) {
		
		for(ProgrammingLanguage programmingLanguage:programmingLanguageRepository.findAll()) {
			
			if(programmingLanguage.getName().equals(name)) {
				
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
