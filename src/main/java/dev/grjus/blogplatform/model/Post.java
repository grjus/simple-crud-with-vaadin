package dev.grjus.blogplatform.model;

import java.time.LocalDate;
import java.util.UUID;

public class Post {

	private UUID uuid = UUID.randomUUID();

	private String title;

	private String description;

	private String text;

	private LocalDate createdAt = LocalDate.now();

	public Post() {
	}

	public Post(String title, String description, String text) {
		this.title = title;
		this.description = description;
		this.text = text;
	}

	@Override
	public String toString() {
		return "Post{" + "uuid=" + uuid + ", title='" + title + '\'' + ", description='" + description + '\''
				+ ", text='" + text + '\'' + ", createdAt=" + createdAt + '}';
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

}
