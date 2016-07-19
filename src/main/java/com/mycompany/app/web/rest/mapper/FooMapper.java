package com.mycompany.app.web.rest.mapper;

import com.mycompany.app.domain.*;
import com.mycompany.app.web.rest.dto.FooDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Foo and its DTO FooDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FooMapper {

    FooDTO fooToFooDTO(Foo foo);

    List<FooDTO> foosToFooDTOs(List<Foo> foos);

    Foo fooDTOToFoo(FooDTO fooDTO);

    List<Foo> fooDTOsToFoos(List<FooDTO> fooDTOs);
}
