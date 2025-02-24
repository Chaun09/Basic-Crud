package f14.example.be_crud_3obj.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StatusReq {
    @NotBlank(message = "Khong dc de trong truong du lieu nay")
    @Size(min = 6, message = "Nhap it nhat 6 ki tu")
    @Pattern(regexp = "^(?!\\s*$)[a-zA-ZÀ-ỹà-ỹ\\s]+$", message = "Khong duoc co ki tu dac biet")
    private String title;
    @Size(min = 10, message = "Nhap it nhat 10 ki tu")
    @NotBlank(message = "Khong dc de trong truong du lieu nay")
    @Pattern(regexp = "^(?!\\s*$)[a-zA-ZÀ-ỹà-ỹ\\s]+$", message = "Khong duoc co ki tu dac biet")
    private String description;
}
