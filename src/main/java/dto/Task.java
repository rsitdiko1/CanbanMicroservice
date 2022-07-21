package dto;

import enums.Status;
import services.UtilsService;

import java.io.IOException;

public class Task  {

    protected Integer id;
    protected String name;
    protected String description;
    protected Status status;

    public Task() {}

    public Task(String name, String description, Status status) throws IOException, InterruptedException {
        this.id = UtilsService.getId();
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Integer getId(){
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus(){
        return status;
    }
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
