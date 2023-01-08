package io.github.vladimirantin.eo.model.lecture;

import com.github.vladimirantin.core.GlobalVariables;
import com.github.vladimirantin.core.reflection.CoreImpl;
import io.github.vladimirantin.eo.model.Person;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * User: vladimir_antin
 * Date: 09.06.2019
 * Time: 17:26
 */
@Entity
@Where(clause = GlobalVariables.WHERE_CLAUSE)
@CoreImpl(type =  {CoreImpl.ImplType.REPO})
public class Professor extends Person {

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull private ProfessorTitle title;

    public ProfessorTitle getTitle() {
        return title;
    }

    public Professor setTitle(ProfessorTitle title) {
        this.title = title;
        return this;
    }
}
