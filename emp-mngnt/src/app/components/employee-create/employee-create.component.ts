import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmployeeService } from '../../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrl: './employee-create.component.css',
})
export class EmployeeCreateComponent {
  employeeForm: FormGroup;

  constructor(
    private bulder: FormBuilder,
    private service: EmployeeService,
    private router: Router
  ) {}

  ngOnInit() {
    this.employeeForm = this.bulder.group({
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
  }

  createEmployee() {
    if (this.employeeForm.valid) {
      this.service.createEmployee(this.employeeForm.value).subscribe((data) => {
        this.router.navigateByUrl('/employee-list');
        console.log(data);
      });
    } else {
      console.log(this.employeeForm.value);
    }
  }
}
