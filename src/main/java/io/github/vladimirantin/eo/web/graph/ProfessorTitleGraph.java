package io.github.vladimirantin.eo.web.graph;

import io.github.vladimirantin.eo.coreImpl.professortitle.ProfessorTitleService;
import io.github.vladimirantin.eo.model.lecture.ProfessorTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Controller
public class ProfessorTitleGraph {

    @Autowired
    ProfessorTitleService professorTitleService;

    @QueryMapping
    public Page<ProfessorTitle> professorTitles(@Argument int page, @Argument int size) {
        return professorTitleService.findAll(PageRequest.of(page, size));
    }

    @QueryMapping
    public ProfessorTitle professorTitle(@Argument Long id) {
        return professorTitleService.findOne(id);
    }

    @MutationMapping
    public ProfessorTitle createProfessorTitle(@Argument ProfessorTitle professorTitle) {
        if (professorTitle.getId() != 0) {
            throw new EntityExistsException();
        }
        return professorTitleService.save(professorTitle);
    }

    @MutationMapping
    public ProfessorTitle updateProfessorTitle(@Argument ProfessorTitle professorTitle) {
        if (professorTitle.getId() == 0 || professorTitleService.findOne(professorTitle.getId()) == null) {
            throw new EntityNotFoundException();
        }
        return professorTitleService.save(professorTitle);
    }

    @MutationMapping
    public String deleteProfessorTitle(@Argument Long id) {
        ProfessorTitle professorTitle = professorTitleService.findOne(id);
        professorTitleService.delete(professorTitle);
        return "";
    }

}
