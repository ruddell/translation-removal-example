package com.mycompany.app.web.rest.dto;

import java.io.Serializable;
import java.util.Objects;

import com.mycompany.app.domain.enumeration.Specialty;

/**
 * A DTO for the Foo entity.
 */
public class FooDTO implements Serializable {

    private Long id;

    private Specialty specialty;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FooDTO fooDTO = (FooDTO) o;

        if ( ! Objects.equals(id, fooDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "FooDTO{" +
            "id=" + id +
            ", specialty='" + specialty + "'" +
            '}';
    }
}
