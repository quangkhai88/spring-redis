package com.tqk.dao;

import com.tqk.bean.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by khaitq
 * Date: 29/04/2018 - Paris, France
 * Github:  https://github.com/quangkhai88
 */

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}
