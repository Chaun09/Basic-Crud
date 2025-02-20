package f14.example.be_crud_3obj.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRes<T> {
    private boolean status;
    private String message;
    private List<T> content;
}
