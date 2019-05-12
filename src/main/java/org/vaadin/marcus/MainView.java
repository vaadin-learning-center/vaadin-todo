package org.vaadin.marcus;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

  private VerticalLayout todosList = new VerticalLayout();
  private TextField taskField = new TextField();
  private Button addButton = new Button("Add");

  public MainView() {
    todosList.setPadding(false);
    taskField.setPlaceholder("Enter task");
    addButton.addClickShortcut(Key.ENTER);
    addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    addButton.addClickListener(this::addTodo);

    add(
        new H1("Vaadin Todo"),
        todosList,
        new HorizontalLayout(
            taskField,
            addButton
        )
    );
  }

  private void addTodo(ClickEvent e) {
    Checkbox doneCheckbox = new Checkbox(taskField.getValue());
    todosList.add(doneCheckbox);

    taskField.clear();
    taskField.focus();
  }
}
