package f14.example.be_crud_3obj.service.task;

import f14.example.be_crud_3obj.dto.req.TaskReq;
import f14.example.be_crud_3obj.dto.res.ApiRes;
import f14.example.be_crud_3obj.dto.res.TaskRes;
import f14.example.be_crud_3obj.entity.Task;
import f14.example.be_crud_3obj.mapping.Mapping;
import f14.example.be_crud_3obj.repository.TaskRepository;
import f14.example.be_crud_3obj.service.status.IStatusService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TaskImpl implements ITaskService {
    private final TaskRepository taskRepository;
    private final IStatusService statusService;

    @Override
    public ApiRes<TaskRes> getAllTask(){
        List<Task> task = taskRepository.findAll();
        List<TaskRes> taskResList = task.stream().map(Mapping::mapTaskDBtoTaskRes).toList();
        if(taskResList.isEmpty()){
            return null;
        }
        return new ApiRes<>(true, "Ds task", taskResList);
    }

    @Override
    public TaskRes findTaskById(Long id){
        taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
        return taskRepository.findById(id).map(Mapping::mapTaskDBtoTaskRes).stream().toList().getFirst();
    }

    @Override
    public ApiRes<TaskRes> createTask(TaskReq taskReq){
        Task task = new Task();
        task.setTitle(taskReq.getTitle());
        task.setDescription(taskReq.getDescription());
        if(taskReq.getProgress() == 100){
                task.setProgress(taskReq.getProgress());
                if(Objects.equals(statusService.findTaskDB(taskReq.getStatus()).getTitle(), "Hoan Thanh")) {
                    task.setStatus(statusService.findTaskDB(taskReq.getStatus()));
                    taskRepository.save(task);
                }
                else {return null;}
        }
        task.setProgress(taskReq.getProgress());
        task.setStatus(statusService.findTaskDB(taskReq.getStatus()));
        taskRepository.save(task);
        return getAllTask();
    }

    @Override
    public ApiRes<TaskRes> deleteTask(Long id){
       taskRepository.deleteById(id);
       return getAllTask();
    }

    @Override
    public ApiRes<TaskRes> updateTask(Long id, TaskReq taskReq){
        Task task = taskRepository.findById(id).get();
        task.setTitle(taskReq.getTitle());
        task.setDescription(taskReq.getDescription());
        if(taskReq.getProgress() == 100){
            task.setProgress(taskReq.getProgress());
            if(Objects.equals(statusService.findTaskDB(taskReq.getStatus()).getTitle(), "Hoan Thanh")) {
                task.setStatus(statusService.findTaskDB(taskReq.getStatus()));
                taskRepository.save(task);
            }
            else {return null;}
        }
        task.setProgress(taskReq.getProgress());
        task.setStatus(statusService.findTaskDB(taskReq.getStatus()));
        taskRepository.save(task);
        return getAllTask();
    }
}
