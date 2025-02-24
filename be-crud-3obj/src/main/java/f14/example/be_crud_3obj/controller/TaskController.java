package f14.example.be_crud_3obj.controller;

import f14.example.be_crud_3obj.dto.req.TaskReq;
import f14.example.be_crud_3obj.service.task.ITaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{api_prefix}/task")
@RequiredArgsConstructor
@CrossOrigin()
public class TaskController {
    private final ITaskService ITaskService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTask() {
        if(ITaskService.getAllTask() == null){
            return ResponseEntity.ok("No task found");
        }
        return ResponseEntity.ok(ITaskService.getAllTask());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@Valid @RequestBody TaskReq taskReq) {
        if(ITaskService.createTask(taskReq) == null){
            return ResponseEntity.ok("Error creating task");
        }
        return ResponseEntity.ok(ITaskService.createTask(taskReq));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        return ResponseEntity.ok(ITaskService.deleteTask(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @Valid @RequestBody TaskReq taskReq) {
        if(ITaskService.updateTask(id, taskReq) == null){
            return ResponseEntity.ok("Error updating task");
        }
        return ResponseEntity.ok(ITaskService.updateTask(id, taskReq));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ITaskService.findTaskById(id));
    }

}
