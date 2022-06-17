package com.example.toDoVaadin;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface TodoRepository extends JpaRepository<Todo, Long> {//basic cleanup operations, that we can then use to query our database


    @Transactional
    void deleteByDone(boolean done);

}
