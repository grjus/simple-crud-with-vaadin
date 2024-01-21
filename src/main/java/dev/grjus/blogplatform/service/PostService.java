package dev.grjus.blogplatform.service;

import dev.grjus.blogplatform.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

@Service
public class PostService implements CrudListener<Post> {

	private static final Logger log = LoggerFactory.getLogger(PostService.class);

	private final JdbcTemplate jdbcTemplate;

	RowMapper<Post> rowMapper = (rs, rowColumn) -> {
		Post post = new Post();
		post.setUuid(rs.getObject("uuid", UUID.class));
		post.setDescription(rs.getString("description"));
		post.setText(rs.getString("text"));
		post.setCreatedAt(rs.getObject("created_at", LocalDate.class));
		post.setTitle(rs.getString("title"));
		return post;
	};

	public PostService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Collection<Post> findAll() {
		String sql = " SELECT uuid, title, description, text, created_at from post";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Post add(Post post) {
		String sql = "INSERT INTO post(title, description, text, uuid, created_at) values (?,?,?,?,?)";
		int insert = jdbcTemplate.update(sql, post.getTitle(), post.getDescription(), post.getText(), post.getUuid(),
				post.getCreatedAt());
		if (insert == 1) {
			log.info("New post created:  " + post.getTitle());

		}
		return post;
	}

	@Override
	public Post update(Post post) {
		String sql = "UPDATE post SET title = ?, description = ?, text = ? WHERE uuid = ?";
		int update = jdbcTemplate.update(sql, post.getTitle(), post.getDescription(), post.getText(), post.getUuid());
		if (update == 1) {
			log.info("Post has been updated: " + post.getUuid());
			return post;
		}
		return null;
	}

	@Override
	public void delete(Post post) {
		String sql = "DELETE from post WHERE uuid = ?";
		int update = jdbcTemplate.update(sql, post.getUuid());
		if (update == 1) {
			log.info("Post has been removed: " + post.getUuid());

		}

	}

}
