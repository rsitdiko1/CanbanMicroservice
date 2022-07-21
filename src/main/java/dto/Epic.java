package dto;

import enums.Status;
import services.UtilsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {

    private List<Integer> subTaskIds = new ArrayList<>();
    private List<SubTask> subTasksTrunk = new ArrayList<>();

    public Epic(String name, String description, Status status) throws IOException, InterruptedException {
        this.id = UtilsService.getId();
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public List<Integer> getSubTaskIds() {
        return subTaskIds;
    }

    public void setSubTaskIds(List<Integer> subTaskIds) {
        this.subTaskIds = subTaskIds;
    }

    public void addSubTask(SubTask subTask) {
        subTaskIds.add(subTask.getId());
        subTasksTrunk.add(subTask);
    }

    public List<SubTask> getSubTasksTrunk() {
        return subTasksTrunk;
    }

    public void clearSubTasks() {
        this.subTasksTrunk = null;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", subTaskIds=" + subTaskIds +
                ", subTasksTrunk=" + subTasksTrunk +
                '}';
    }
}
