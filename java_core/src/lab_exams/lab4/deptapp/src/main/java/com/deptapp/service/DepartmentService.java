package com.deptapp.service;

import com.deptapp.dto.Department;

public interface DepartmentService {
    Department getByName(String name);
}
