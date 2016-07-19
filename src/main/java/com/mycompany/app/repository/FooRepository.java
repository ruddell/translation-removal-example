package com.mycompany.app.repository;

import com.mycompany.app.domain.Foo;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Foo entity.
 */
@SuppressWarnings("unused")
public interface FooRepository extends JpaRepository<Foo,Long> {

}
