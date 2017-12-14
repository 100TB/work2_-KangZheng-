package com.example.demo;

import com.example.model.Article;
import com.example.model.Comment;
import com.example.model.User;
import com.example.service.ArticleService;
import com.example.service.CommentService;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BbsApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentService;

	@Test
	public void contextLoads() {
		 User user=new User();
		user.setPhone("13211111111");
		userService.findUserByPhone(user);
		userService.listUser();
		 System.out.println(user);
		List<Article> list=articleService.listArticle();
		for (Article a:list
			 ) {
			System.out.println(a.getContent());
		}
		articleService.getListByid(1);

		commentService.listComment(1);
	}


}
