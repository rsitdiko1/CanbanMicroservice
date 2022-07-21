import dto.Epic;
import dto.SubTask;
import dto.Task;
import enums.Status;
import managers.HistoryManager;
import managers.Managers;
import managers.TaskManager;

import java.io.IOException;
import java.util.List;

public class Main {
    private static TaskManager manager = Managers.getDefault();
    private static HistoryManager historyManager = Managers.getHistoryManager();

    public static void main(String[] args)  throws IOException, InterruptedException {

        print(getTestData());
        System.out.println("\n");

        System.out.println("Меняем статус у Task");
        Task task = manager.getById(0);
        task.setStatus(Status.DONE);
        manager.updateTask(task);
        print(task);
        System.out.println("\n");

        System.out.println("Меняем статус у SubTask и смотрим на статус Epic");
        SubTask subTask = (SubTask) manager.getById(4);
        subTask.setStatus(Status.DONE);
        manager.updateSubTask(subTask);
        print(subTask);
        print(manager.getById(2));
        System.out.println("\n");

        manager.removeTaskById(0);
        manager.removeEpicById(5);
        print(manager.getAll());
        System.out.println("\n");

        manager.clearAll();
        historyManager.clearHistory();
        System.out.println("Должна выводиться пустая история");
        System.out.println(historyManager.getHistory());

        manager.addTask(new Task("task1", "task1_description", Status.NEW));
        manager.getById(7);
        manager.addTask(new Task("task2", "task2_description", Status.DONE));
        manager.getById(8);
        System.out.println("Должна выводиться история из 2х тасок: id=8, id=7");
        System.out.println(historyManager.getHistory());

        for(int i = 0; i < 7; i++){
            manager.getById(8);
        }
        manager.addEpic(new Epic("epic1", "epic1_description", Status.DONE));
        manager.getById(9);
        System.out.println("Должна выводиться история не более чем из 10ти тасок. 1я - эпик");
        System.out.println(historyManager.getHistory());
    }

    private static List<Task> getTestData() throws IOException, InterruptedException {
        Task buyBread = new Task(
                "купить хлеб",
                "буханку подового и матнакаш",
                Status.NEW
        );

        Task buyMilk = new Task(
                "купить молоко",
                "2л, жирность 3.2",
                Status.NEW
        );

        Epic vacation = new Epic (
                "отпуск",
                "поехать в отпуск и отдохнуть как нормальный человек",
                Status.IN_PROGRESS
        );

        SubTask tickets = new SubTask(
                vacation.getId(),
                "билеты",
                "найти дешевые билеты и забронировать",
                Status.DONE
        );

        SubTask hotel = new SubTask(
                vacation.getId(),
                "гостиница",
                "найти нормальную гостиницу с одним приемом пищи",
                Status.IN_PROGRESS
        );

        vacation.addSubTask(tickets);
        vacation.addSubTask(hotel);

        Epic gym = new Epic(
                "тренажерный зал",
                "начать посещать тренажерный зал, чтобы остаться в живых",
                Status.NEW
        );

        SubTask willpower = new SubTask(
                gym.getId(),
                "сила воли",
                "тренировать силу воли, чтобы регулярно посещать тренажерный зал",
                Status.NEW
        );

        gym.addSubTask(willpower);

        manager.addTask(buyBread);
        manager.addTask(buyMilk);
        manager.addEpic(vacation);
        manager.addEpic(gym);

        return manager.getAll();
    }

    private static void print(List<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void print(Task task) {
        System.out.println(task);
    }
}
