package com.ibm.SpringBootDemo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.SpringBootDemo.model.TodoModel;

@Component
public class TodDoService {
	private static List<TodoModel> todoModel = new ArrayList<TodoModel>();
	private static int todoCount = 3;
	static {
		todoModel.add(new TodoModel(101, "vipul", "learn Spring", new Date(), false));
		todoModel.add(new TodoModel(102, "vipul", "learn hibernate", new Date(), false));
		todoModel.add(new TodoModel(103, "vipul", "learn Spring boot", new Date(), false));

	}

	public List<TodoModel> reteriveTodos(String user) {
		List<TodoModel> filtered = new ArrayList<TodoModel>();
		for (TodoModel loginModel : todoModel) {
			if (loginModel.getUser().equals(user)) {
				filtered.add(loginModel);

			}

		}

		return filtered;
	}

	public void addToDos(String user, String desc, Date targetDate, boolean isDone) {
		todoModel.add(new TodoModel(++todoCount, user, desc, targetDate, isDone));
	}

	public void deleteToDos(int id) {
		Iterator<TodoModel> iterator = todoModel.iterator();
		while (iterator.hasNext()) {
			TodoModel model = iterator.next();
			if (model.getId() == id) {
				iterator.remove();

			}

		}
	}

}
