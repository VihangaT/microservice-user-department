package com.microservices.vt.tech.departmentuser.service;

import com.microservices.vt.tech.departmentuser.entity.Department;
import com.microservices.vt.tech.departmentuser.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public Department saveDepartment(Department department) {
        log.info("inside saveDepartment-service");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("inside findDepartmentById-service");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
