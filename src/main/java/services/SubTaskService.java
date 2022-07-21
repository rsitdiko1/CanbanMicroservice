package services;

import dao.SubTaskDao;
import dto.Epic;
import dto.SubTask;

import java.util.ArrayList;
import java.util.List;

public class SubTaskService {
    SubTaskDao subTaskDao = new SubTaskDao();
    EpicService epicService = new EpicService();

    public SubTask getById(int id) {
        return subTaskDao.getById(id);
    }

    public void add(SubTask obj) {
        subTaskDao.add(obj);
        Epic epic = epicService.getById(obj.getEpicId());
        epicService.updateEpicStatus(epic);
        epicService.add(epic);
    }

    public void update(SubTask obj) {
        subTaskDao.add(obj);
        Epic epic = epicService.getById(obj.getEpicId());
        epicService.updateEpicStatus(epic);
        epicService.updateEpicStatus(epic);
    }

    public void removeById(Integer id) {
        int epicId = subTaskDao.getById(id).getEpicId();
        Epic epic = epicService.getById(epicId);
        subTaskDao.removeById(id);
        epicService.updateEpicStatus(epic);
    }

    public List<SubTask> getAll() {
        return subTaskDao.getAll();
    }

    public void removeAll() {
        subTaskDao.removeAll();
    }

    public boolean containsKey(Integer key) {
        return subTaskDao.containsKey(key);
    }

    public List<SubTask> getAllByEpic(Epic epic) {
        List<Integer> subTaskIds = epic.getSubTaskIds();
        List<SubTask> answer = new ArrayList<>();
        for (Integer id : subTaskIds) {
            answer.add(subTaskDao.getById(id));
        }
        return answer;
    }
}
