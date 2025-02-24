package f14.example.be_crud_3obj.service.status;

import f14.example.be_crud_3obj.dto.req.StatusReq;
import f14.example.be_crud_3obj.dto.res.ApiRes;
import f14.example.be_crud_3obj.dto.res.StatusRes;
import f14.example.be_crud_3obj.entity.Status;

public interface IStatusService {
    ApiRes<StatusRes> getAllStatus();

    ApiRes<StatusRes> createStatus(StatusReq statusReq);

    ApiRes<StatusRes> deleteStatus(Long id);

    StatusRes findStatusById(Long id);

    ApiRes<StatusRes> updateStatus(Long id, StatusReq statusReq);

    Status findTaskDB(Long id);
}
