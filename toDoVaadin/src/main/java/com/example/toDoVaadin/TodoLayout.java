package com.example.toDoVaadin;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringComponent//avoiding naming conflict
public class TodoLayout extends VerticalLayout {

    @Autowired
    TodoRepository repo;

    //go to repository and pull up todos
    @PostConstruct
    void init(){//do initialization- like constructor

       update();
    }

    private void update() {
        setTodos(repo.findAll());
    }

    private void setTodos(List<Todo> todos) {

        removeAllComponents();  //no previous todos

        todos.forEach(todo -> addComponent(new TodoItemLayout(todo)));
    }

    public void add(Todo todo) {

        repo.save(todo);
        update();

    }

    public void deleteCompleted() {
        repo.deleteByDone(true);
        update();
    }
}
