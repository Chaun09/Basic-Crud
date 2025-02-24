package f14.example.be_crud_3obj.service.task;

import f14.example.be_crud_3obj.dto.req.TaskReq;
import f14.example.be_crud_3obj.dto.res.ApiRes;
import f14.example.be_crud_3obj.dto.res.TaskRes;


public interface ITaskService {
    ApiRes<TaskRes> getAllTask();

    ApiRes<TaskRes> createTask(TaskReq taskReq);

    TaskRes findTaskById(Long id);

    ApiRes<TaskRes> deleteTask(Long id);

    ApiRes<TaskRes> updateTask(Long id, TaskReq taskReq);
}
