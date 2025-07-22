package MyTaskApp.MyTaskList.tasks;


import MyTaskApp.MyTaskList.categories.Category;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {

    @Id
    String taskId;
    String taskTitle;
    String taskNote;
    Category taskCategory;
    String taskDate;
    boolean hasDone;
    public Task() {
    }
    public Task(String taskTitle, String taskNote, Category taskCategory, String taskDate, boolean hasDone) {
        this.taskTitle = taskTitle;
        this.taskNote = taskNote;
        this.taskCategory = taskCategory;
        this.taskDate = taskDate;
        this.hasDone = hasDone;

    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskNote() {
        return taskNote;
    }

    public void setTaskNote(String taskNote) {
        this.taskNote = taskNote;
    }

    public Category getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(Category taskCategory) {
        this.taskCategory = taskCategory;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }
    public boolean isHasDone() {
        return hasDone;
    }
    public void setHasDone(boolean hasDone) {
        this.hasDone = hasDone;
    }
}
