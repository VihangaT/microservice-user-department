package com.microservices.vt.tech.departmentuser.repository;

import com.microservices.vt.tech.departmentuser.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentId(Long departmentId);
}
