package managers;

import dto.Epic;
import dto.SubTask;
import dto.Task;

import java.util.List;

public interface TaskManager {

    List<Task> getAll();

    void clearAll();

    Task getById(int id);

    void addTask(Task obj);

    void updateTask(Task obj);

    void addEpic(Epic obj);

    void addSubTask(SubTask obj);

    void updateEpic(Epic obj);

    void updateSubTask(SubTask obj);

    void removeTaskById(Integer id);

    void removeEpicById(Integer id);

    void removeSubTaskById(Integer id);

    List<SubTask> getSubTasksByEpic(Epic epic);
}
