package f14.example.be_crud_3obj.service.status;

import f14.example.be_crud_3obj.dto.req.StatusReq;
import f14.example.be_crud_3obj.dto.res.ApiRes;
import f14.example.be_crud_3obj.dto.res.StatusRes;
import f14.example.be_crud_3obj.entity.Status;
import f14.example.be_crud_3obj.mapping.Mapping;
import f14.example.be_crud_3obj.repository.StatusRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusImpl implements IStatusService{
    private final StatusRepository statusRepository;

    @Override
    public ApiRes<StatusRes> getAllStatus() {
        List<Status> status = statusRepository.findAll();
        List<StatusRes> statusResList = status.stream().map(Mapping::mapStatusDBtoStatusRes).toList();
        if(statusResList.isEmpty()){
            return null;
        }
        return new ApiRes<>(true, "Ds status:", statusResList);
    }

    @Override
    public ApiRes<StatusRes> createStatus(StatusReq statusReq){
        Status status = new Status();
        status.setDescription(statusReq.getDescription());
        status.setTitle(statusReq.getTitle());
        statusRepository.save(status);
        return getAllStatus();
    }

    @Override
    public ApiRes<StatusRes> deleteStatus(Long id){
        statusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Status not found with id: " + id));
        statusRepository.deleteById(id);
        return getAllStatus();
    }

    @Override
    public StatusRes findStatusById(Long id){
        statusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Status not found with id: " + id));
        return statusRepository.findById(id).map(Mapping::mapStatusDBtoStatusRes).stream().toList().getFirst();
    }

    @Override
    public  ApiRes<StatusRes> updateStatus(Long id, StatusReq statusReq){
        Status status = statusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Status not found with id: " + id));
        status.setDescription(statusReq.getDescription());
        status.setTitle(statusReq.getTitle());
        statusRepository.save(status);
        return getAllStatus();
    }


}
