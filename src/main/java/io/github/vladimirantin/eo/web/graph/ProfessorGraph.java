package io.github.vladimirantin.eo.web.graph;

import io.github.vladimirantin.eo.model.lecture.Professor;
import io.github.vladimirantin.eo.service.ProfessorService;
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
public class ProfessorGraph {

    @Autowired
    ProfessorService professorService;

    @QueryMapping
    public Page<Professor> professors(@Argument int page, @Argument int size) {
        return professorService.findAll(PageRequest.of(page, size));
    }

    @QueryMapping
    public Professor professor(@Argument Long id) {
        return professorService.findOne(id);
    }

    @MutationMapping
    public Professor createProfessor(@Argument Professor professor) {
        if (professor.getId() != 0) {
            throw new EntityExistsException();
        }
        return professorService.save(professor);
    }

    @MutationMapping
    public Professor updateProfessor(@Argument Professor professor) {
        if (professor.getId() == 0 || professorService.findOne(professor.getId()) == null) {
            throw new EntityNotFoundException();
        }
        return professorService.save(professor);
    }

    @MutationMapping
    public String deleteProfessor(@Argument Long id) {
        Professor professor = professorService.findOne(id);
        professorService.delete(professor);
        return "";
    }

}
