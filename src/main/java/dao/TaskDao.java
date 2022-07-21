package dao;

import dto.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskDao {

    private static Map<Integer, Task> db = new HashMap<>();

    public void add(Task obj) {
        db.put(obj.getId(), obj);
    }

    public void update(Task obj) {
        db.put(obj.getId(), obj);
    }

    public Task getById(int id) {
        return db.get(id);
    }

    public List<Task> getAll() {
        return new ArrayList<>(db.values());
    }

    public void removeById(Integer id) {
        db.remove(id);
    }

    public void removeAll() {
        db.clear();
    }

    public boolean containsKey(Integer key) {
        return db.containsKey(key);
    }
}
