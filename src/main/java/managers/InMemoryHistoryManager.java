package managers;

import dao.TaskStackDao;
import dto.Task;

import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private static TaskStackDao dao = new TaskStackDao();

    @Override
    public void add(Task task) {
        dao.add(task);
    }

    @Override
    public List<Task> getHistory() {
        return dao.getHistory();
    }

    @Override
    public void clearHistory() {
        dao.clear();
    }
}
