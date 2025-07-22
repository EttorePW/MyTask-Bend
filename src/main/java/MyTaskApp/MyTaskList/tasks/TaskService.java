package MyTaskApp.MyTaskList.tasks;

import MyTaskApp.MyTaskList.categories.Category;
import MyTaskApp.MyTaskList.categories.CategoryRepository;
import MyTaskApp.MyTaskList.tasks.dtos.NewTaskDTO;
import MyTaskApp.MyTaskList.tasks.dtos.TaskDTO;
import MyTaskApp.MyTaskList.tasks.dtos.UpdatedTaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public TaskDTO createTask(NewTaskDTO newTaskDTO){
        Task task = new Task(newTaskDTO.getTaskTitle(), newTaskDTO.getTaskNote(), getCategoryByName(newTaskDTO.getTaskCategory()), newTaskDTO.getTaskDate(), newTaskDTO.isHasDone());
        taskRepository.save(task);
        return convertTaskToTaskDTO(task);
    }
    public Category  getCategoryByName(String category){
       return (Category) categoryRepository.findCategoryByCategoryName(category)
               .stream().findFirst().orElseThrow(()->new IllegalArgumentException("Category not found"));

    }
    public TaskDTO convertTaskToTaskDTO(Task task){
        return new TaskDTO(task.getTaskId(), task.getTaskTitle(),  task.getTaskNote(), task.getTaskCategory(), task.getTaskDate(), task.isHasDone());
    }
    public List<TaskDTO> getTasks(){
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOs = new ArrayList<>();
        tasks.forEach(task -> taskDTOs.add(convertTaskToTaskDTO(task)));
        return taskDTOs;
    }
    public TaskDTO getTaskById(String taskId){
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        return convertTaskToTaskDTO(task);
    }
    public TaskDTO updateTask(String id,UpdatedTaskDTO updatedTaskDTO){
        Task updatedTask = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        updatedTask.setHasDone(updatedTaskDTO.isHasDone());
        taskRepository.save(updatedTask);
        return convertTaskToTaskDTO(updatedTask);
    }
    public void deleteTask(String taskId){
        taskRepository.deleteById(taskId);
    }

}
