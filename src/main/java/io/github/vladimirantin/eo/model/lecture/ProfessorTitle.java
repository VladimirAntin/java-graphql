package io.github.vladimirantin.eo.model.lecture;

import com.github.vladimirantin.core.GlobalVariables;
import com.github.vladimirantin.core.model.CoreModel;
import com.github.vladimirantin.core.reflection.CoreImpl;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * User: vladimir_antin
 * Date: 09.06.2019
 * Time: 17:39
 */
@Entity
@Where(clause = GlobalVariables.WHERE_CLAUSE)
@CoreImpl(type =  {CoreImpl.ImplType.REPO, CoreImpl.ImplType.SERVICE})
public class ProfessorTitle extends CoreModel {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public ProfessorTitle setName(String name) {
        this.name = name;
        return this;
    }
}
