package services;

import dao.EpicDao;
import dao.SubTaskDao;
import dto.Epic;
import dto.SubTask;
import dto.Task;
import enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EpicService {
    EpicDao epicDao = new EpicDao();
    SubTaskDao subTaskDao = new SubTaskDao();

    public void add(Epic obj) {
        List<SubTask> subTasks = obj.getSubTasksTrunk();
        for (SubTask subTask : subTasks) {
            subTaskDao.add(subTask);
        }
        obj.clearSubTasks();
        updateEpicStatus(obj);
        epicDao.add(obj);
    }

    public Epic getById(int id) {
        return epicDao.getById(id);
    }

    public void update(Epic obj) {
        List<SubTask> subTasks = obj.getSubTasksTrunk();
        for (SubTask subTask : subTasks) {
            subTaskDao.add(subTask);
        }
        updateEpicStatus(obj);
        epicDao.add(obj);
    }

    public void removeById(Integer id) {
        List<Integer> subTaskIds = epicDao.getById(id).getSubTaskIds();
        for (Integer subTaskId : subTaskIds) {
            subTaskDao.removeById(subTaskId);
        }
        epicDao.removeById(id);
    }

    public List<Epic> getAll() {
        return epicDao.getAll();
    }

    public void removeAll() {
        epicDao.removeAll();
    }
    public boolean containsKey(Integer key) {
        return epicDao.containsKey(key);
    }

    public void updateEpicStatus(Epic epic) {
        List<Integer> ids = epic.getSubTaskIds();

        List<SubTask> subTasks = new ArrayList<>();
        for (Integer id : ids) {
            subTasks.add(subTaskDao.getById(id));
        }

        List<Status> statuses = subTasks.stream()
                .map(Task::getStatus)
                .distinct()
                .collect(Collectors.toList());

        Status realStatus;
        if (statuses.size() > 1) {
            realStatus = Status.IN_PROGRESS;
        } else if (statuses.size() == 0) {
            return;
        } else {
            realStatus = statuses.get(0);
        }
        epic.setStatus(realStatus);
    }
}
