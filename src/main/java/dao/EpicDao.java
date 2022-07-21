package dao;

import dto.Epic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpicDao {
    private static Map<Integer, Epic> db = new HashMap<>();

    public void add(Epic obj) {
        db.put(obj.getId(), obj);
    }

    public void update(Epic obj) {
        db.put(obj.getId(), obj);
    }

    public Epic getById(int id) {
        return db.get(id);
    }

    public List<Epic> getAll() {
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
