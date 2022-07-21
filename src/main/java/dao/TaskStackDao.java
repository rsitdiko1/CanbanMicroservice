package dao;

import collections.TaskStack;
import dto.Task;

import java.util.List;

public class TaskStackDao {

    private static final int STACK_SIZE = 10;
    TaskStack<Task> db = new TaskStack<>(STACK_SIZE);

    public void add(Task obj) {
        db.push(obj);
    }

    public List<Task> getHistory() {
        return db.getReversedOrder();
    }

    public void clear() {
        db.removeAll();
    }
}
