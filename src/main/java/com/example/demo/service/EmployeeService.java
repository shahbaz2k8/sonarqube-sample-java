/*
*  Copyright (c) 2019. All right reserved
* Created on 2024-05-14 ( Date ISO 2024-05-14 - Time 18:11:42 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.example.demo.service;
import com.example.demo.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Service Interface for managing {@link Employee}.
*  @author aek
 */
public interface EmployeeService  {
   
    /**
     * create new item for domain
     *
     * @param entity entity to save.
     * @return persisted entity Employee
     */
    Employee create(Employee d);

    /**
     * Update entity. Check before if existing data. If data is empty throw Exception
     *
     * @param entity domain
     * @param id of entity
     * @return Employee
     */
    Employee update(Employee d);

    /**
     * get Employee by id. Can be return empty
     *
     * @param id the id of the entity.
     * @return Employee
     */
    Employee getOne(Integer id) ;

    /**
     * Get all entities
     *
     * @return list of entities List<Employee>
     */
    List<Employee> getAll();

    /**
     * Count item in entity
     *
     * @return long 
     */
    long getTotal();

    /**
     * Delete record by id
     *  
     */
    void delete(Integer id);

    /**
     * Find all with pagination
     *
     * @return Page<Employee>  
     */
    Page<Employee> findAllPaginate(Pageable pageable);

    /**
     * Find all with pagination  by criteria 
     *
     * @return Page<Employee>  
     */
	Page<Employee> findAllSpecification(Specification<Employee> specs, Pageable pageable);

}
