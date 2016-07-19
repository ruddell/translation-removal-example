package com.mycompany.app.service;

import com.mycompany.app.domain.Foo;
import com.mycompany.app.repository.FooRepository;
import com.mycompany.app.web.rest.dto.FooDTO;
import com.mycompany.app.web.rest.mapper.FooMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Foo.
 */
@Service
@Transactional
public class FooService {

    private final Logger log = LoggerFactory.getLogger(FooService.class);
    
    @Inject
    private FooRepository fooRepository;
    
    @Inject
    private FooMapper fooMapper;
    
    /**
     * Save a foo.
     * 
     * @param fooDTO the entity to save
     * @return the persisted entity
     */
    public FooDTO save(FooDTO fooDTO) {
        log.debug("Request to save Foo : {}", fooDTO);
        Foo foo = fooMapper.fooDTOToFoo(fooDTO);
        foo = fooRepository.save(foo);
        FooDTO result = fooMapper.fooToFooDTO(foo);
        return result;
    }

    /**
     *  Get all the foos.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<Foo> findAll(Pageable pageable) {
        log.debug("Request to get all Foos");
        Page<Foo> result = fooRepository.findAll(pageable); 
        return result;
    }

    /**
     *  Get one foo by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public FooDTO findOne(Long id) {
        log.debug("Request to get Foo : {}", id);
        Foo foo = fooRepository.findOne(id);
        FooDTO fooDTO = fooMapper.fooToFooDTO(foo);
        return fooDTO;
    }

    /**
     *  Delete the  foo by id.
     *  
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Foo : {}", id);
        fooRepository.delete(id);
    }
}
