package services;

import dao.TaskDao;
import dto.Task;

import java.util.List;

public class TaskService {
    TaskDao dao = new TaskDao();

    public void add(Task obj) {
        dao.add(obj);
    }

    public void update(Task obj) {
        dao.update(obj);
    }

    public Task getById(int id) {
        return dao.getById(id);
    }

    public List<Task> getAll() {
        return dao.getAll();
    }

    public void removeById(Integer id) {
        dao.removeById(id);
    }

    public void removeAll() {
        dao.removeAll();
    }

    public boolean containsKey(Integer key) {
        return dao.containsKey(key);
    }
}
