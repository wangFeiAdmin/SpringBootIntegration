package com.wf.service;

import com.wf.pojo.Department;
import com.wf.pojo.Employee;

import java.util.Collection;

public interface EmpService {
    Collection<Employee> getAll();
    Collection<Department> getDeptAll();
    void  addEmp(Employee empService);
    Employee getEmployee(Integer id);
    void  deleteEmp(Integer id);
}
