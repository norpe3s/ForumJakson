package telran.forum.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.forum.domain.Comment;
import telran.forum.domain.Post;

public class ForumAppl {

	static ObjectMapper mapper = new ObjectMapper();
	
	
	
	
	public static void main(String[] args) throws JsonProcessingException {
		
		mapper.findAndRegisterModules();
		
		Map<Long, Post> forum = new HashMap<>();
		Post post = new Post(1, "JAva EE", "Super puper", "Java Fun",
				new HashSet<>(Arrays.asList("Java", "Server", "BackEnd")));

		forum.put(post.getId(), post);
		String json = mapper.writeValueAsString(forum);
		System.out.println(json);
		
		forum.get(1l).addComment(new Comment("NewBorn", "Bla Bla Bla comments"));
		forum.get(1l).addLike();
		
		json = mapper.writeValueAsString(forum);
		System.out.println(json);
		

	}

}
