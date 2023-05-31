package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.EmployeeRequest
import ua.kpi.its.lab.rest.dto.EmployeeResponse
interface EmployeeService {
    fun createEmployee(request: EmployeeRequest): EmployeeResponse
    fun getAllEmployees(): List<EmployeeResponse>
    fun getEmployeeById(id: Long): EmployeeResponse
    fun updateEmployee(id: Long, request: EmployeeRequest): EmployeeResponse
    fun deleteEmployee(id: Long): Boolean
}