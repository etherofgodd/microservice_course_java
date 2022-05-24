package com.etherofgodd.studentdal.repositories;

import com.etherofgodd.studentdal.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {


}
