package dto;

import enums.Status;
import services.UtilsService;

import java.io.IOException;

public class SubTask extends Task {

    private final Integer epicId;

    public SubTask(Integer epicId, String name, String description, Status status) throws IOException, InterruptedException {
        this.id = UtilsService.getId();
        this.epicId = epicId;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Integer getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "id=" + id +
                ", epicId=" + epicId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
