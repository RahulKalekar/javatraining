package com.empapp.serviceproxy;

import com.empapp.dto.Department;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DepartmentFallback implements DeptServiceProxy{
    private final Map<String, Department> departmentMap;

    public DepartmentFallback() {
        this.departmentMap = new HashMap<>();
        departmentMap.put("IT", new Department(1, "IT", "NULL"));
        departmentMap.put("SALES", new Department(2, "SALES", "NULL"));
    }

    @Override
    public Department getByName(String name) {
        return departmentMap.get(name);
    }
}
