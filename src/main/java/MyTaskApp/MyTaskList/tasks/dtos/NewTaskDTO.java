package MyTaskApp.MyTaskList.tasks.dtos;


public class NewTaskDTO {

    String taskTitle;
    String taskNote;
    String taskCategory;
    String taskDate;
    boolean hasDone;
    public NewTaskDTO() {
    }
    public NewTaskDTO(String taskTitle, String taskNote, String taskCategory, String taskDate, boolean hasDone) {
        this.taskTitle = taskTitle;
        this.taskNote = taskNote;
        this.taskCategory = taskCategory;
        this.taskDate = taskDate;
        this.hasDone = hasDone;

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

    public String getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(String taskCategory) {
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
