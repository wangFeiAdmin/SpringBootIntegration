package com.wf.serviceImpl;

import com.wf.dao.DepartmentDao;
import com.wf.dao.EmployeeDao;
import com.wf.pojo.Department;
import com.wf.pojo.Employee;
import com.wf.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao department;

    /**
     * 查询全部员工
     * @return
     */
    public Collection<Employee> getAll(){

            return employeeDao.getAll();
    }

    /**
     * 查询所有部门
     * @return
     */
    public  Collection<Department> getDeptAll(){
        return department.getDepartments();
    }

    /**
     * 添加员工
     * @return
     */
    public void  addEmp(Employee empService){
        employeeDao.save(empService);
    }

    /**
     * 插叙指定员工
     * @param id
     * @return
     */
    public Employee getEmployee(Integer id){
        return employeeDao.get(id);
    }

    /**
     * 删除员工
     * @param id
     */
    public  void  deleteEmp(Integer id){
        employeeDao.delete(id);
    }
}
