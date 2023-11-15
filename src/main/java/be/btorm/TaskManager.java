package be.btorm;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public boolean addTask(Task task){
        return tasks.add(task);
    }

    public boolean removeTask(String description){
        Task t = findTaskByDescription(description);
        if(t == null){
            return false;
        }
        return tasks.remove(t);
    }

    public boolean markAsCompleted(String description){
        Task t = findTaskByDescription(description);
        if(t == null){
            return false;
        }
        t.markAsCompleted();
        return true;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> getPendingTasks(){

        return tasks.stream()
                .filter(t -> !t.isCompleted())
                .toList();
    }

    public List<Task> getCompletedTasks(){

        return tasks.stream()
                .filter(Task::isCompleted)
                .toList();
    }

    public Task findTaskByDescription(String description){
//        for (Task t : tasks){
//            if(t.getDescription().equals(description)){
//                return t;
//            }
//        }
//        return null;
        return tasks.stream()
                .filter(t -> t.getDescription().equals(description))
                        .findFirst()
                        .orElse(null);
    }
}
