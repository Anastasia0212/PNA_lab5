package ua.kpi.its.lab.rest.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.EmployeeRequest
import ua.kpi.its.lab.rest.dto.EmployeeResponse
import ua.kpi.its.lab.rest.svc.impl.EmployeeServiceImpl

@RestController
@RequestMapping("/employee")
class EmployeeController(private val serviceImpl: EmployeeServiceImpl) {
    @PostMapping
    fun createEmployee(@RequestBody req: EmployeeRequest): ResponseEntity<EmployeeResponse> {
        val response = serviceImpl.createEmployee(req)
        return ResponseEntity(response, HttpStatus.CREATED)
    }

    @GetMapping("/")
    fun getEmployees(): ResponseEntity<List<EmployeeResponse>> {
        val response = serviceImpl.getAllEmployees()
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): ResponseEntity<EmployeeResponse> {
        val response = serviceImpl.getEmployeeById(id)
        if (response.equals(null)) {
            println("Employee {$id} not found")
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable id: Long, @RequestBody req: EmployeeRequest): ResponseEntity<EmployeeResponse> {
        val response = serviceImpl.updateEmployee(id, req)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<Void> {
        serviceImpl.deleteEmployee(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}