package f14.example.be_crud_3obj.controller;

import f14.example.be_crud_3obj.dto.req.StatusReq;
import f14.example.be_crud_3obj.service.status.IStatusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/{api_prefix}/status")
@RequiredArgsConstructor
@CrossOrigin()
public class StatusController {
    private final IStatusService IStatusService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStatus() {
        if(IStatusService.getAllStatus() == null){
            return ResponseEntity.ok("No status found");
        }
        return ResponseEntity.ok(IStatusService.getAllStatus());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStatus(@Valid @RequestBody StatusReq statusReq) {
        return ResponseEntity.ok(IStatusService.createStatus(statusReq));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable Long id) {
        return ResponseEntity.ok(IStatusService.deleteStatus(id));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findStatusById(@PathVariable Long id) {
        return ResponseEntity.ok(IStatusService.findStatusById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id,@Valid @RequestBody StatusReq statusReq) {
        return ResponseEntity.ok(IStatusService.updateStatus(id, statusReq));
    }
}
