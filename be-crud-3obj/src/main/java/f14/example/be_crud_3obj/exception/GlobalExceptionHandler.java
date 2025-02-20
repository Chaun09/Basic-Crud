package f14.example.be_crud_3obj.exception;


import f14.example.be_crud_3obj.dto.res.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ResponseObject> handleGeneralException(Exception exception) {
        return ResponseEntity.internalServerError().body(
                ResponseObject.builder()
                        .status(HttpStatus.CONFLICT)
                        .message(exception.getMessage())
                        .build()
        );
    }
//    @ExceptionHandler(DataNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<?> handleResourceNotFoundException(Exception exception) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseObject.builder()
//                .status(HttpStatus.NOT_FOUND)
//                .message(exception.getMessage())
//                .build());
//    }

//    @ExceptionHandler(DataNotFoundException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<?> handleResourceBadRequestException(Exception exception) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObject.builder()
//                .status(HttpStatus.BAD_REQUEST)
//                .message(exception.getMessage())
//                .build());
//    }

}

