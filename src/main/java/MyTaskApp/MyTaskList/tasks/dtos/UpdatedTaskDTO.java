package MyTaskApp.MyTaskList.tasks.dtos;


public class UpdatedTaskDTO {


    String taskId;
    boolean hasDone;
    public UpdatedTaskDTO() {
    }
    public UpdatedTaskDTO(String taskId,boolean hasDone) {
        this.taskId = taskId;
        this.hasDone = hasDone;

    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public boolean isHasDone() {
        return hasDone;
    }

    public void setHasDone(boolean hasDone) {
        this.hasDone = hasDone;
    }
}
