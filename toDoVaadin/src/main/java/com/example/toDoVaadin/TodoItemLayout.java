package com.example.toDoVaadin;

import com.vaadin.data.Binder;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class TodoItemLayout extends HorizontalLayout {
    private final CheckBox done;
    private final TextField text;

    public TodoItemLayout(Todo todo) {
        done = new CheckBox();//same names as jpa entity (data binding trick)
        text = new TextField();
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);


        addComponents(done);
        addComponentsAndExpand(text);setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        Binder<Todo> binder = new Binder<>(Todo.class);
        binder.bindInstanceFields(this);//look at the fields in this layout and match those to the fields in the to do object
        binder.setBean(todo);//call binder
    }
}
