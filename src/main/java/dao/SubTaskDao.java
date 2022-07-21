package dao;

import dto.SubTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubTaskDao {
    private static Map<Integer, SubTask> db = new HashMap<>();

    public void add(SubTask obj) {
        db.put(obj.getId(), obj);
    }

    public void update(SubTask obj) {
        db.put(obj.getId(), obj);
    }

    public SubTask getById(int id) {
        return db.get(id);
    }

    public List<SubTask> getAll() {
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
