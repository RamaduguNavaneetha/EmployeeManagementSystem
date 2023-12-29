import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Employee } from '../../common/employee';
import { EmployeeService } from '../../services/employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrl: './employee-edit.component.css',
})
export class EmployeeEditComponent {
  employeeForm: FormGroup;
  employee: Employee = new Employee();
  id: number;

  constructor(
    private builder: FormBuilder,
    private service: EmployeeService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.employeeForm = this.builder.group({
      employeeId: [
        '',
        [Validators.required, Validators.pattern('^[6-9][0-9]{9}$')],
      ],
      employeeName: [
        '',
        [Validators.required, Validators.pattern('^[a-zA-Z]*$')],
      ],
      employeeEmail: ['', [Validators.required, Validators.email]],
      
      employeeMobile: [
        '',
        [Validators.required, Validators.pattern('^[6-9][0-9]{9}$')],
      ],
      employeeSalary: ['', Validators.required],
    });

    //reading id given in the ListComponent onclikc of EDIT Button
    this.id = this.activatedRoute.snapshot.params['id'];

    this.service.getEmployee(this.id).subscribe((data) => {
      this.employee = data;
      console.log(data);
    });
  }

  updateEmployee() {
    if (confirm("Are you sure to update?")) {
      this.service.updateEmployee(this.employee).subscribe((data) => {
        alert("Employee is updated")
        this.router.navigateByUrl('employee-list');
      });
    }

  }
}