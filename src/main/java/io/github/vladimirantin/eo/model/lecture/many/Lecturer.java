package io.github.vladimirantin.eo.model.lecture.many;

import com.github.vladimirantin.core.GlobalVariables;
import com.github.vladimirantin.core.model.CoreModel;
import com.github.vladimirantin.core.reflection.CoreImpl;
import io.github.vladimirantin.eo.model.lecture.Course;
import io.github.vladimirantin.eo.model.lecture.Professor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * User: vladimir_antin
 * Date: 09.06.2019
 * Time: 17:28
 */
@Entity
@Where(clause = GlobalVariables.WHERE_CLAUSE)
@CoreImpl(type =  {CoreImpl.ImplType.REPO, CoreImpl.ImplType.SERVICE})
public class Lecturer extends CoreModel {

    @ManyToOne
    @NotNull private Professor professor;
    @ManyToOne
    @NotNull private Course course;

    public Professor getProfessor() {
        return professor;
    }

    public Lecturer setProfessor(Professor professor) {
        this.professor = professor;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public Lecturer setCourse(Course course) {
        this.course = course;
        return this;
    }
}
