package telran.forum.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = {"id"})

public class Post {
	
	@Setter long id;
	@Setter String title;
	String content;
	String author;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	LocalDateTime dateCreated;
	Set<String> tags;
	int likes;
	Set<Comment> comments;
	
	public Post(long id, String title, String content, String author, Set<String> tags) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.tags = tags;
		dateCreated = LocalDateTime.now();
		comments = new HashSet<>();
		
	}
	
	public void addLike() {
		likes++;
	}
	
	
 public boolean addComment(Comment comment) {
	return comments.add(comment);
}
 
 public boolean addTags(String tag) {
	return tags.add(tag);
}
 
 public boolean removeTags(String tag) {
	return tags.remove(tag);
}
	
	
}
