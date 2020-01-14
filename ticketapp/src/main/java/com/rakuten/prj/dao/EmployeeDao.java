/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import com.rakuten.prj.entity.Employee;

/**
 * @author nishanth
 *
 */
public interface EmployeeDao {
	void addEmployee(Employee e);
	Employee getEmployee(int id);
	List<Employee> getEmployees();
}
