package co.grandcircus.capstone6;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.capstone6.DAO.UserRepo;
import co.grandcircus.capstone6.Entities.User;

@Controller
@RequestMapping("/tasklist")
public class LoginController {

	@Autowired
	private HttpSession sesh;
 
	@Autowired
	private UserRepo userRep;
	
	@RequestMapping("/")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@PostMapping("/logcheck")
	public ModelAndView check(@RequestParam("name") String name, @RequestParam("password")
	String password, RedirectAttributes redirect) {
		User user = userRep.findByNameIgnoreCase(name);
		if(user==null || !password.contentEquals(user.getPassword())){
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("message", "Invalid Entry");
			return mav;
		} else {
			sesh.setAttribute("user", user);
			//^can now used 'user' for the session (IF it is not void)
			redirect.addFlashAttribute("message", "Successful Login");
			return new ModelAndView("redirect:/tasklist/"+user.getId());
		}
	
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(RedirectAttributes out) {
		sesh.invalidate();
		out.addFlashAttribute("message", "Logged Out");
		return new ModelAndView("redirect:/tasklist/");
	}
	
	
}
