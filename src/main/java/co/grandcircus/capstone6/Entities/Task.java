package co.grandcircus.capstone6.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String duedate;
	private Boolean complete=false;
	
	@ManyToOne
	private User user;
	
	public Task() {
		
	}
	public Task(String description, String due, User user) {
		this.description=description;
		this.duedate=due;
		this.user=user;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String dueDate) {
		this.duedate = dueDate;
	}
	public Boolean getComplete() {
		return complete;
	}
	public void setComplete(Boolean complete) {
		this.complete = complete;
	}
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", dueDate=" + duedate + ", complete=" + complete
				+ ", user=" + user.getName() + "]";
	}
	
	

	
	
	

}
