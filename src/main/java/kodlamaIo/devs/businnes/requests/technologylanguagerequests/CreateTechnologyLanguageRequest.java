package kodlamaIo.devs.businnes.requests.technologylanguagerequests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTechnologyLanguageRequest {
	
	private String name;
	
	private int programmingLanguageId;

}
