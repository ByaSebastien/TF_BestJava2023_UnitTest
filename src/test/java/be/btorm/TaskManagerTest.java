package be.btorm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @AfterEach
    void tearDown() {
        taskManager = null;
    }

    @Test
    void testAddTask(){
        Task task = new Task("Task 1");
        boolean result = taskManager.addTask(task);

        assertTrue(result);
        List<Task> pendingTask = taskManager.getPendingTasks();
        assertEquals(1,pendingTask.size());
        assertEquals("Task 1",pendingTask.get(0).getDescription());
        assertFalse(pendingTask.get(0).isCompleted());
    }

    @Test
    void testRemoveTaskWithSuccess(){
        Task task = new Task("Task 1");
        taskManager.addTask(task);
        boolean result = taskManager.removeTask("Task 1");
        assertTrue(result);
        List<Task> pendingTask = taskManager.getPendingTasks();
        assertEquals(0,pendingTask.size());
    }

    @Test
    void testRemoveTaskWithFailure(){
        Task task = new Task("Task 1");
        taskManager.addTask(task);
        boolean result = taskManager.removeTask("Error");
        assertFalse(result);
        List<Task> pendingTask = taskManager.getPendingTasks();
        assertEquals(1,pendingTask.size());
    }

    @Test
    void testMarkAsCompletedWithSuccess(){
        Task task = new Task("Task 1");
        taskManager.addTask(task);
        boolean result = taskManager.markAsCompleted("Task 1");
        assertTrue(result);
        List<Task> pendingTask = taskManager.getPendingTasks();
        List<Task> completedTask = taskManager.getCompletedTasks();
        assertEquals(0,pendingTask.size());
        assertEquals(1,completedTask.size());
        assertTrue(completedTask.get(0).isCompleted());
    }

    @Test
    void testMarkAsCompletedWithFailure(){
        Task task = new Task("Task 1");
        taskManager.addTask(task);
        boolean result = taskManager.markAsCompleted("Error");
        assertFalse(result);
        List<Task> pendingTask = taskManager.getPendingTasks();
        List<Task> completedTask = taskManager.getCompletedTasks();
        assertEquals(1,pendingTask.size());
        assertEquals(0,completedTask.size());
        assertFalse(pendingTask.get(0).isCompleted());
    }
}