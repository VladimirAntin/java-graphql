package io.github.vladimirantin.eo.service;

import com.github.vladimirantin.core.service.CoreModelService;
import io.github.vladimirantin.eo.coreImpl.professor.ProfessorRepo;
import io.github.vladimirantin.eo.coreImpl.professortitle.ProfessorTitleService;
import io.github.vladimirantin.eo.model.lecture.Professor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService extends CoreModelService<ProfessorRepo, Professor> {

    @Autowired
    private ProfessorTitleService professorTitleService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    public Professor save(Professor entity){
        log.info("Save one (entity: {}, repo: {})", getEntityName(), getRepoName());
        entity.setTitle(professorTitleService.findOne(entity.getTitle().getId()));
        return repo.save(entity);
    }

}
