package kodlamaIo.devs.dataAcces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaIo.devs.entities.TechnologyLanguage;

@Repository
public interface TechnologyLanguageRepository  extends JpaRepository<TechnologyLanguage, Integer> {
	
	TechnologyLanguage findById(int id);

}
