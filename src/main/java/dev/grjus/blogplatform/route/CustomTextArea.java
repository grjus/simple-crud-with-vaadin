package dev.grjus.blogplatform.route;

import com.vaadin.flow.component.textfield.TextArea;

public class CustomTextArea extends TextArea {

	public CustomTextArea() {
		setPlaceholder("Write your blog post here...");
		setMinWidth("100%");
		setMinHeight("200px");
		setMaxHeight("600px");

	}

}
