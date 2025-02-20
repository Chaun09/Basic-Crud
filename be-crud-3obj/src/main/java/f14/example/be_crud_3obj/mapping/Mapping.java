package f14.example.be_crud_3obj.mapping;

import f14.example.be_crud_3obj.dto.res.StatusRes;
import f14.example.be_crud_3obj.entity.Status;

public class Mapping {
    public static StatusRes mapStatusDBtoStatusRes(Status statusDB){
        return StatusRes.builder().id(statusDB.getId()).title(statusDB.getTitle()).description(statusDB.getDescription()).build();
    }
}
