package co.grandcircus.capstone6;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

import co.grandcircus.capstone6.Entities.Task;

public final class TaskSort implements Comparator<Task> {



	@Override
	public int compare(Task o1, Task o2) {
	//	int startComparison(o1.getDuedate(), o2.getDuedate());
		return 0;
	}
	
	
	public static List<Task> sortByDescription(List<Task> tasks){
		if (tasks.size()>1) {
			Collections.sort(tasks, new Comparator<Task>() {
					public int compare(Task t1, Task t2) {
				String d1=t1.getDescription();
				String d2=t2.getDescription();
				return d1.compareTo(d2);
			}
		});
			}
				return tasks;	
	
		
	}
	
	public static List<Task> sortByComplete(List<Task> tasks){
		if (tasks.size()>1) {
			Collections.sort(tasks, new Comparator<Task>() {
					public int compare(Task t1, Task t2) {
				Boolean c1=t1.getComplete();
				Boolean c2=t2.getComplete();
				return c1.compareTo(c2);
			}
		});
			}
				return tasks;	
	
	}

	public static List<Task> sortByDate(List<Task> tasks) {
		
		if (tasks.size()>1) {
		Collections.sort(tasks, new Comparator<Task>() {
				public int compare(Task t1, Task t2) {
			String d1=t1.getDuedate();
			String d2=t2.getDuedate();
			Date date1 = dateGet(d1);
			Date date2 = dateGet(d2);
			
			return date1.compareTo(date2);
		}
	});
		}
			return tasks;	
	}
	
	public static Date dateGet(String date) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = new Date();
		try {
			date1=df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date1;
	}
	
		
//		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//			String d1=o1.getDuedate();
//			String d2=o2.getDuedate();
//			Date date1 = new Date();
//			Date date2 = new Date();
//			try {
//				date1=df.parse(d1);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				date2=df.parse(d1);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//		//	List<Task> sortedList = .stream().sorted().collect(Collectors.toList());   
//			
//		
//			
//			return 0;
//		}

	
	
}
