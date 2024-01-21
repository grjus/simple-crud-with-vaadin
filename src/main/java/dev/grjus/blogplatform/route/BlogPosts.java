package dev.grjus.blogplatform.route;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import dev.grjus.blogplatform.model.Post;
import dev.grjus.blogplatform.service.PostService;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route("")
public class BlogPosts extends VerticalLayout {

	public BlogPosts(PostService postService) {
		var crud = new GridCrud<>(Post.class, postService);
		crud.getGrid().setColumns("title", "description", "createdAt");
		crud.getCrudFormFactory().setVisibleProperties("title", "description", "text");
		crud.getCrudFormFactory().setFieldType("text", CustomTextArea.class);

		add(new H1("Blog posts"), crud);
	}

	private TextArea createTextArea() {
		TextArea textArea = new TextArea();

		return textArea;
	}

}
