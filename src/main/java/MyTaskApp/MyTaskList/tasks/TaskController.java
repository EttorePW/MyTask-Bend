package MyTaskApp.MyTaskList.tasks;

import MyTaskApp.MyTaskList.tasks.dtos.NewTaskDTO;
import MyTaskApp.MyTaskList.tasks.dtos.TaskDTO;
import MyTaskApp.MyTaskList.tasks.dtos.UpdatedTaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskDTO> getTasks() {
        return taskService.getTasks();
    }
    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }
    @PostMapping
    public TaskDTO postTask(@RequestBody NewTaskDTO newTaskDTO) {
        return taskService.createTask(newTaskDTO);
    }
    @PutMapping("/{id}")
    public TaskDTO putTask(@PathVariable String id, @RequestBody UpdatedTaskDTO updatedTaskDTO) {
        return taskService.updateTask(id,updatedTaskDTO);
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return "Task Deleted";
    }
}
