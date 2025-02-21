import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { APIRes } from '../../interfaces/APIRes.interfaces';
import { Domain, Status } from '../../constant/Api';
import { StatusDto } from '../../interfaces/Dto.intefaces';
import { StatusDT } from '../../interfaces/Status.interfaces';

@Injectable({
  providedIn: 'root',
})
export class StatusServiceService {
  constructor(private http: HttpClient) {}
  getAllStatus(): Observable<APIRes> {
    return this.http.get<APIRes>(Domain + Status.getAll);
  }
  deleteStatus(id: number): Observable<APIRes> {
    return this.http.delete<APIRes>(Domain + Status.delete + id);
  }
  createStatus(data: StatusDto): Observable<APIRes> {
    return this.http.post<APIRes>(Domain + Status.create, data, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
  }
  updateStatus(data: StatusDto, id: number): Observable<APIRes> {
    return this.http.put<APIRes>(Domain + Status.update + id, data, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
  }

  getStatusById(id: number): Observable<StatusDT> {
    return this.http.get<StatusDT>(Domain + Status.findById + id);
  }
}
