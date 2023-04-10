package kodlamaIo.devs.businnes.responses.technologylanguageresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTechnologyLanguageById {
	
	private int id;
	private String name;
	
	private int programmingLanguageId;
	
	private String programmingLanguageName;
	

}
