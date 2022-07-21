package managers;

import dto.Epic;
import dto.SubTask;
import dto.Task;
import exceptions.SomethingWentWrongException;
import services.EpicService;
import services.SubTaskService;
import services.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InMemoryTaskManager implements TaskManager {

    private EpicService epicService = new EpicService();
    private TaskService taskService = new TaskService();
    private SubTaskService subTaskService = new SubTaskService();
    private HistoryManager historyManager = Managers.getHistoryManager();

    @Override
    public List<Task> getAll() {
        List<Task> answer = new ArrayList<>();
        Stream.of(taskService.getAll(), epicService.getAll(), subTaskService.getAll())
                .forEach(answer::addAll);
        return answer;
    }

    @Override
    public void clearAll() {
        taskService.removeAll();
        epicService.removeAll();
        subTaskService.removeAll();
    }

    @Override
    public Task getById(int id) {
        if (taskService.containsKey(id)) {
            Task task = taskService.getById(id);
            historyManager.add(task);
            return task;
        }
        if (epicService.containsKey(id)) {
            Epic epic = epicService.getById(id);
            historyManager.add(epic);
            return epic;
        }
        else if (subTaskService.containsKey(id)) {
            SubTask subTask = subTaskService.getById(id);
            historyManager.add(subTask);
            return subTask;
        }
        else
            throw new SomethingWentWrongException("Отсутствует объект с id: " + id);
    }

    @Override
    public void addTask(Task obj) {
        taskService.add(obj);
    }

    @Override
    public void updateTask(Task obj) {
        taskService.add(obj);
    }

    @Override
    public void addEpic(Epic obj) {
        epicService.add(obj);
    }

    @Override
    public void addSubTask(SubTask obj) {
        subTaskService.add(obj);
    }

    @Override
    public void updateEpic(Epic obj) {
        epicService.update(obj);
    }

    @Override
    public void updateSubTask(SubTask obj) {
        subTaskService.update(obj);
    }

    @Override
    public void removeTaskById(Integer id) {
        taskService.removeById(id);
    }

    @Override
    public void removeEpicById(Integer id) {
        epicService.removeById(id);
    }

    @Override
    public void removeSubTaskById(Integer id) {
        subTaskService.removeById(id);
    }

    @Override
    public List<SubTask> getSubTasksByEpic(Epic epic) {
        return subTaskService.getAllByEpic(epic);
    }
}
