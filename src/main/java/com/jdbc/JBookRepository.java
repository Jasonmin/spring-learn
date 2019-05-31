package com.jdbc;

//import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.awt.print.Pageable;
import java.util.List;

public interface JBookRepository extends CrudRepository<JBook,Long> {

    List<JBook> findByTitle(String title);

//    Page<JBook> findPage(Pageable pageable);
}
