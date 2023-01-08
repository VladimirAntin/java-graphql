package io.github.vladimirantin.eo.model;

import com.github.vladimirantin.core.model.CoreModel;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * User: vladimir_antin
 * Date: 09.06.2019
 * Time: 18:21
 */
@MappedSuperclass
public class Person extends CoreModel {

    @NotNull private String name;
    @NotNull private String surname;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }
}
