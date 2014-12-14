package com.asayama.gwt.angular.site.examples.client;

import java.util.Date;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.datepicker.client.DatePicker;

public class GwtWidgetsExampleController implements Controller {

    // TODO automatically export the IsWidget instance members?
    private DialogBox dialogBox = null;
    private Button button = null;
    private DatePicker datePicker = null;

    @Override
    public void onControllerLoad() {
        button = createButton();
        datePicker = createDatePicker();
    }
    
    private void shout(String text) {
        if (dialogBox == null) {
            dialogBox = new GwtWidgetDemoDialogBox();
        }
        dialogBox.setText(text);
        dialogBox.center();
    }
    
    private Button createButton() {
        Button button = new Button("This is a GWT Button");
        button.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                shout("You clicked GWT Button");
            }
        });
        return button;
    }

    private DatePicker createDatePicker() {
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(new Date(), false);
        datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {

            public void onValueChange(ValueChangeEvent<Date> event) {
                Date date = event.getValue();
                shout("You selected " + date);
            }
        });
        return datePicker;
    }
    
    // Getters and Setters
    
    public Button getButton() {
        return button;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }
}

class GwtWidgetDemoDialogBox extends DialogBox {

    public GwtWidgetDemoDialogBox() {
        setText("GWT DialogBox");
        setAnimationEnabled(true);
        setGlassEnabled(true);
        Button ok = new Button("OK");
        ok.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                GwtWidgetDemoDialogBox.this.hide();
            }
        });
        setWidget(ok);
    }
}
