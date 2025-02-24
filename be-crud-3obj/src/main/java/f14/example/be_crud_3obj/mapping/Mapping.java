package f14.example.be_crud_3obj.mapping;

import f14.example.be_crud_3obj.dto.res.StatusRes;
import f14.example.be_crud_3obj.dto.res.TaskRes;
import f14.example.be_crud_3obj.entity.Status;
import f14.example.be_crud_3obj.entity.Task;

public class Mapping {
    public static StatusRes mapStatusDBtoStatusRes(Status statusDB){
        return StatusRes.builder().id(statusDB.getId()).title(statusDB.getTitle()).description(statusDB.getDescription()).build();
    }
    public static TaskRes mapTaskDBtoTaskRes(Task taskDB){
        return TaskRes.builder().id(taskDB.getId()).title(taskDB.getTitle()).description(taskDB.getDescription()).status(taskDB.getStatus()).progress(taskDB.getProgress()).build();
    }
}
