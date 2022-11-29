package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

//	@Autowired
//	private PostRepository postRepo;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private RolesRepository rolesRepository;

	@GetMapping("/blog")
	public String blogMain(Model model) {
//		Iterable<Post> posts = postRepo.findAll();
//		model.addAttribute("posts", posts);

		Iterable<Users> users = usersRepository.findAll();
		model.addAttribute("users", users);

		Iterable<Roles> roles = rolesRepository.findAll();
		model.addAttribute("roles", roles);

		return "blog-main";
	}

}
