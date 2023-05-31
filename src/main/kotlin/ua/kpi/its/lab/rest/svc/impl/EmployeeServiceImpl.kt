package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.EmployeeRequest
import ua.kpi.its.lab.rest.dto.EmployeeResponse
import ua.kpi.its.lab.rest.entity.Employee
import ua.kpi.its.lab.rest.repository.EmployeeRepository
import ua.kpi.its.lab.rest.svc.EmployeeService
@Service
class EmployeeServiceImpl(private val employeeRepository: EmployeeRepository) : EmployeeService {
    @PreAuthorize("hasAuthority('REDACTOR')")
    override fun createEmployee(employeeRequest: EmployeeRequest): EmployeeResponse {
        val employee = Employee(fullName = employeeRequest.fullName, category = employeeRequest.category)
        val savedEmployee = employeeRepository.save(employee)
        return EmployeeResponse.fromEntity(savedEmployee)
    }

    @PreAuthorize("hasAuthority('VIEWER')")
    override fun getEmployeeById(id: Long): EmployeeResponse {
        val employee = employeeRepository.findById(id).orElseThrow()
        return EmployeeResponse.fromEntity(employee)
    }

    @PreAuthorize("hasAuthority('VIEWER')")
    override fun getAllEmployees(): List<EmployeeResponse> {
        val employees = employeeRepository.findAll().orElseThrow()
        return EmployeeResponse.fromEntity(employees)
    }

    @PreAuthorize("hasAuthority('REDACTOR')")
    override fun updateEmployee(id: Long, employeeRequest: EmployeeRequest): EmployeeResponse {
        val employee = employeeRepository.findById(id).orElseThrow()
        employee.fullName = employeeRequest.fullName
        employee.category = employeeRequest.category
        val updatedEmployee = employeeRepository.save(employee)
        return EmployeeResponse.fromEntity(updatedEmployee)
    }

    @PreAuthorize("hasAuthority('REDACTOR')")
    override fun deleteEmployee(id: Long): Boolean {
        employeeRepository.deleteById(id)
        return true
    }
}