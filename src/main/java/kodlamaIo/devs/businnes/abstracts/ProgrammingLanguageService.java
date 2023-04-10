package kodlamaIo.devs.businnes.abstracts;

import java.util.List;

import kodlamaIo.devs.businnes.requests.programminglanguagerequests.CreateProgrammingLanguageRequest;
import kodlamaIo.devs.businnes.requests.programminglanguagerequests.DeleteProgrammingLanguageRequest;
import kodlamaIo.devs.businnes.requests.programminglanguagerequests.UpdateProgrammingLanguageRequest;
import kodlamaIo.devs.businnes.responses.programminglanguageresponse.GetAllProgrammingLanguageResponse;
import kodlamaIo.devs.businnes.responses.programminglanguageresponse.GetProgrammingLanguageById;
import kodlamaIo.devs.core.utilities.results.DataResult;
import kodlamaIo.devs.core.utilities.results.Result;

public interface ProgrammingLanguageService {
	
	Result add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	
	Result update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
	
	Result delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
	
	DataResult<List<GetAllProgrammingLanguageResponse>> getAll();
	
	DataResult<GetProgrammingLanguageById> findById(int id);
	

}
