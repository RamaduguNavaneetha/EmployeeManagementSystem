import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../common/employee';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  basePath: string = 'http://localhost:8081/api/employee';

  constructor(private http: HttpClient) {}

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.basePath);
  }

  createEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.basePath, employee);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.basePath}/${id}`);
  }

  getEmployee(id: number): Observable<Employee> {
    return this.http.get<Employee>(`${this.basePath}/${id}`);
  }

  updateEmployee(employee: Employee): Observable<any> {
    return this.http.put(this.basePath, employee);
  }
}
