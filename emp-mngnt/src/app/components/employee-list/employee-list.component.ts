import { Component } from '@angular/core';
import { Employee } from '../../common/employee';
import { EmployeeService } from '../../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css',
})
export class EmployeeListComponent {
  employees: Employee[];

  constructor(private service: EmployeeService, private router: Router) {}

  showEdit(id: number) {
    this.router.navigate(['employee-edit', id]);
  }

  getEmployees() {
    this.service.getEmployees().subscribe((data) => {
      this.employees = data;
      console.log(data)
    });
  }

  ngOnInit() {
    this.getEmployees();
  }

  deleteEmployee(id: number) {
    if (confirm('Are you sure delete this emloyee?')) {
      this.service.deleteEmployee(id).subscribe((data) => {
        this.getEmployees();
      });
    }
  }
}
