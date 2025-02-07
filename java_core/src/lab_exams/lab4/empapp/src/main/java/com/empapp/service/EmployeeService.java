package com.empapp.service;

import com.empapp.dto.EmpDeptDto;
import com.empapp.dto.Employee;

public interface EmployeeService {
    EmpDeptDto getByName(String name);
}
