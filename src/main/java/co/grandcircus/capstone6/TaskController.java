package co.grandcircus.capstone6;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.capstone6.DAO.TaskRepo;
import co.grandcircus.capstone6.DAO.UserRepo;
import co.grandcircus.capstone6.Entities.Task;
import co.grandcircus.capstone6.Entities.User;

@Controller
@RequestMapping("/tasklist")
public class TaskController {
	static Boolean valid =false;
	
	@Autowired
	private HttpSession sesh;
	
	@Autowired
	private TaskRepo taskRep;

	@Autowired
	private UserRepo userRep;
	
	@RequestMapping("/addTask")
	public ModelAndView addTask(@RequestParam("id") Long id) {
		return new ModelAndView("task-add", "user", userRep.findById(id).orElse(null));
	}
	
	@PostMapping("/addTask")
	public ModelAndView taskAdd(Task task) {
		taskRep.save(task);
		return new ModelAndView("redirect:/tasklist/" +task.getUser().getId());
	}
	
	@RequestMapping("/complete")
	public ModelAndView complete(@RequestParam("comp") Long id) {
		
		Task task = taskRep.findById(id).orElse(null);
		task.setComplete(!task.getComplete());
		taskRep.save(task);
		
		return new ModelAndView("redirect:/tasklist/"+task.getUser().getId());
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("del") Long id) {
		Task task=taskRep.findById(id).orElse(null);
		Long a = task.getUser().getId();
		taskRep.delete(task);
		return new ModelAndView("redirect:/tasklist/"+a +"");
	}
	
	@RequestMapping("/confirm")
	public ModelAndView sure(@RequestParam("del") Long id) {
		return new ModelAndView("confirm", "task", taskRep.findById(id).orElse(null));
	}
	
	@RequestMapping("/sortDate")
	public ModelAndView sortDate(@RequestParam("id") Long id) {
		User user = userRep.findById(id).orElse(null);
		List<Task>tasks = user.getTasks();
		tasks = TaskSort.sortByDate(tasks);
		user.setTasks(tasks);
		return new ModelAndView("user-view", "user", user);
	}
	
	@RequestMapping("/sortComp")
	public ModelAndView sortComplete(@RequestParam("id") Long id) {
		User user = userRep.findById(id).orElse(null);
		List<Task>tasks = user.getTasks();
		tasks = TaskSort.sortByComplete(tasks);
		user.setTasks(tasks);
		return new ModelAndView("user-view", "user", user);
	}
	
	@RequestMapping("/sortDes")
	public ModelAndView sortDescription(@RequestParam("id") Long id) {
		User user = userRep.findById(id).orElse(null);
		List<Task>tasks = user.getTasks();
		tasks = TaskSort.sortByDescription(tasks);
		user.setTasks(tasks);
		return new ModelAndView("user-view", "user", user);
	}
	

}
