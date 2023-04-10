package kodlamaIo.devs.businnes.abstracts;

import java.util.List;

import kodlamaIo.devs.businnes.requests.technologylanguagerequests.CreateTechnologyLanguageRequest;
import kodlamaIo.devs.businnes.requests.technologylanguagerequests.DeleteTechnologyLanguageRequest;
import kodlamaIo.devs.businnes.requests.technologylanguagerequests.UpdateTechnologyLanguageRequest;
import kodlamaIo.devs.businnes.responses.technologylanguageresponse.GetAllTechnologyResponse;
import kodlamaIo.devs.businnes.responses.technologylanguageresponse.GetTechnologyLanguageById;
import kodlamaIo.devs.core.utilities.results.DataResult;
import kodlamaIo.devs.core.utilities.results.Result;

public interface TechnologyLanguageService {
	
	Result add(CreateTechnologyLanguageRequest createTechnologyLanguageRequest) throws Exception;
	Result update(UpdateTechnologyLanguageRequest updateTechnologyLanguageRequest) throws Exception;
	Result delete(DeleteTechnologyLanguageRequest deleteTechnologyLanguageRequest);
	
	DataResult<List<GetAllTechnologyResponse>> getAll();
	DataResult<GetTechnologyLanguageById> findById(int id);
	

}
