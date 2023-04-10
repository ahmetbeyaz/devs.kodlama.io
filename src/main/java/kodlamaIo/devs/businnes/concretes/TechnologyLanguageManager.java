package kodlamaIo.devs.businnes.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIo.devs.businnes.abstracts.TechnologyLanguageService;
import kodlamaIo.devs.businnes.requests.technologylanguagerequests.CreateTechnologyLanguageRequest;
import kodlamaIo.devs.businnes.requests.technologylanguagerequests.DeleteTechnologyLanguageRequest;
import kodlamaIo.devs.businnes.requests.technologylanguagerequests.UpdateTechnologyLanguageRequest;
import kodlamaIo.devs.businnes.responses.technologylanguageresponse.GetAllTechnologyResponse;
import kodlamaIo.devs.businnes.responses.technologylanguageresponse.GetTechnologyLanguageById;
import kodlamaIo.devs.core.utilities.results.DataResult;
import kodlamaIo.devs.core.utilities.results.Result;
import kodlamaIo.devs.core.utilities.results.SuccessDataResult;
import kodlamaIo.devs.core.utilities.results.SuccessResult;
import kodlamaIo.devs.dataAcces.ProgrammingLanguageRepository;
import kodlamaIo.devs.dataAcces.TechnologyLanguageRepository;
import kodlamaIo.devs.entities.ProgrammingLanguage;
import kodlamaIo.devs.entities.TechnologyLanguage;

@Service
public class TechnologyLanguageManager implements TechnologyLanguageService {
	
	@Autowired
	private TechnologyLanguageRepository technologyLanguageRepository;
	
	@Autowired
	private ProgrammingLanguageRepository programmingLanguageRepository;
	

	@Override
	public Result add(CreateTechnologyLanguageRequest createTechnologyLanguageRequest) throws Exception {
		
		if(createTechnologyLanguageRequest.getName().isBlank()||isValidNameExist(createTechnologyLanguageRequest.getName())) {
			
			throw new Exception("İsim alani bos gecilemez");
		}
		TechnologyLanguage technologyLanguage=new TechnologyLanguage();
		ProgrammingLanguage programmingLanguage=
				programmingLanguageRepository.findById
				(createTechnologyLanguageRequest.getProgrammingLanguageId());
		
		technologyLanguage.setName(createTechnologyLanguageRequest.getName());
		technologyLanguage.setProgrammingLanguage(programmingLanguage);
		
		
		
		this.technologyLanguageRepository.save(technologyLanguage);
		return new SuccessResult("Technology added");
		
	}

	@Override
	public Result update(UpdateTechnologyLanguageRequest updateTechnologyLanguageRequest) throws Exception {
	if(updateTechnologyLanguageRequest.getName().isBlank()||isValidNameExist(updateTechnologyLanguageRequest.getName())) {
			
			throw new Exception("İsim alani bos gecilemez");
		}
		
		
		TechnologyLanguage technologyLanguage=new TechnologyLanguage();
		technologyLanguage.setId(updateTechnologyLanguageRequest.getId());
		technologyLanguage.setName(updateTechnologyLanguageRequest.getName());
		
		this.technologyLanguageRepository.save(technologyLanguage);
		
		return new SuccessResult("Technology updated");
		
	}

	@Override
	public Result delete(DeleteTechnologyLanguageRequest deleteTechnologyLanguageRequest) {
		TechnologyLanguage technologyLanguage =new TechnologyLanguage();
		technologyLanguage.setId(deleteTechnologyLanguageRequest.getId());
		
		this.technologyLanguageRepository.delete(technologyLanguage);
		
		return new SuccessResult("Technology deleted");
	
		
	}

	@Override
	public DataResult<List<GetAllTechnologyResponse>> getAll() {
		
		List<TechnologyLanguage>  technologyLanguages=technologyLanguageRepository.findAll();
		List<GetAllTechnologyResponse> getAllTechnologyResponses=new ArrayList<>();
		
		for(TechnologyLanguage technologyLanguage:technologyLanguages ) {
			GetAllTechnologyResponse technologyItem=new GetAllTechnologyResponse();
			technologyItem.setId(technologyLanguage.getId());
			technologyItem.setName(technologyLanguage.getName());
			
			technologyItem.setProgrammingLanguageId(technologyLanguage.getProgrammingLanguage().getId());
			technologyItem.setProgrammingLanguageName(technologyLanguage.getProgrammingLanguage().getName());
			
			
			
             getAllTechnologyResponses.add(technologyItem);			
			
		}
		
		return new SuccessDataResult<List<GetAllTechnologyResponse>>(getAllTechnologyResponses,"Data list");
		
	}

	@Override
	public DataResult<GetTechnologyLanguageById> findById(int id) {
		
		TechnologyLanguage technologyLanguage =technologyLanguageRepository.findById(id);
		GetTechnologyLanguageById technologyLanguageById=new GetTechnologyLanguageById();
		
		technologyLanguageById.setId(technologyLanguage.getId());
		technologyLanguageById.setName(technologyLanguage.getName());
		
		
		technologyLanguageById.setProgrammingLanguageId(technologyLanguage.getProgrammingLanguage().getId());
		technologyLanguageById.setProgrammingLanguageName(technologyLanguage.getProgrammingLanguage().getName());
		
		return new SuccessDataResult<GetTechnologyLanguageById>(technologyLanguageById,"id show");
		
		
		
	}
	
	
	
	
	public boolean isValidNameExist(String name) {
		
		for(TechnologyLanguage technologyLanguage:technologyLanguageRepository.findAll()) {
			if(technologyLanguage.getName().equals(name)) {
				
				return true;
			}
			
		}
		
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
