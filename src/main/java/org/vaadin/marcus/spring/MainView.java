package org.vaadin.marcus.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

  public MainView() {
    VerticalLayout todosList = new VerticalLayout();
    TextField todoField = new TextField();
    Button addButton = new Button("Add");

    addButton.addClickListener(click-> {
      Checkbox checkbox = new Checkbox(todoField.getValue());
      todosList.add(checkbox);
    });

    add(
      new H1("Vaadin Todo"),
      todosList,
      new HorizontalLayout(
          todoField,
          addButton
      )
    );
  }

}
