package kodlamaIo.devs.dataAcces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaIo.devs.entities.ProgrammingLanguage;

@Repository
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
	
	ProgrammingLanguage  findById(int id);

}
