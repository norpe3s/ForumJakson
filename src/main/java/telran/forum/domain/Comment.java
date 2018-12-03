package telran.forum.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = { "user","dateCreated" })

public class Comment {
	String user;
	@Setter
	String message;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	LocalDateTime dateCreated;
	int likes;

	public Comment(String user, String message) {
		this.user = user;
		this.message = message;
		dateCreated = LocalDateTime.now();
	}
	
	public void addLike() {
		likes++;
	}

}
