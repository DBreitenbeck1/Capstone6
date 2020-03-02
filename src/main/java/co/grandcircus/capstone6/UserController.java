package co.grandcircus.capstone6;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.capstone6.DAO.UserRepo;
import co.grandcircus.capstone6.Entities.User;

@Controller
@RequestMapping("/tasklist")
public class UserController {

	@Autowired
	private HttpSession sesh;
	
	@Autowired
	private UserRepo userRep;
	
	@RequestMapping("/userList")
	public ModelAndView userList() {
		return new ModelAndView("user-list", "users", userRep.findAll());
	}
	
	@RequestMapping("/addUser")
	public ModelAndView userAdd() {
		return new ModelAndView("user-add");
	}
	
	
	@PostMapping("/addUser")
	public ModelAndView newUser(@RequestParam("password") String pass, 
			@RequestParam("passwordconf") String conf, RedirectAttributes redirect,
			User user) {
		if(pass.equals(conf)) {
		userRep.save(user);
		return new ModelAndView("redirect:/tasklist/"+user.getId());
		}
		else {
			redirect.addFlashAttribute("message", "Password Does Not Match");
			return new ModelAndView("redirect:/tasklist/addUser");
		}
	}

	@RequestMapping("/{id}")
	public ModelAndView showUser(@PathVariable("id") User user) {
		
		return new ModelAndView("user-view","user", user);
	}
	
	
}
