package f14.example.be_crud_3obj.dto.res;

import f14.example.be_crud_3obj.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRes {
    private Long id;
    private String title;
    private int progress;
    private String description;
    private Status status;
}

