package ua.kpi.its.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.EnterpriseRequest
import ua.kpi.its.lab.rest.dto.EnterpriseResponse
import ua.kpi.its.lab.rest.svc.impl.EnterpriseServiceImpl


@RestController
@RequestMapping("/api/enterprise")
class EnterpriseController {

    private final lateinit var serviceImpl: EnterpriseServiceImpl;

    @Autowired
    fun EnterpriseController(serviceImpl: EnterpriseServiceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @GetMapping("/{id}")
    fun getEnterpriseById(@PathVariable Long id): ResponseEntity<EnterpriseResponse>? {
        val response: EnterpriseResponse = serviceImpl.getEnterpriseById(id);
        if (response.equals(null)) {
            println("Enterprise {$id} not found")
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    fun createEnterprise(@Valid @RequestBody enterpriseRequest: EnterpriseRequest?): ResponseEntity<EnterpriseResponse>? {
        val response: EnterpriseResponse? = enterpriseRequest?.let { serviceImpl.createEnterprise(it) }
        return ResponseEntity.status(HttpStatus.CREATED).body<EnterpriseResponse>(response)
    }

    @PutMapping("/{id}")
    fun updateEnterprise(
        @PathVariable id: Long,
        @Valid @RequestBody enterpriseRequest: EnterpriseRequest?
    ): ResponseEntity<EnterpriseResponse>? {
        val response: EnterpriseResponse? = enterpriseRequest?.let { serviceImpl.updateEnterprise(id, it) }
        return ResponseEntity.ok<EnterpriseResponse>(response)
    }

    @DeleteMapping("/{id}")
    fun deleteEnterprise(@PathVariable id: Long): ResponseEntity<Void?>? {
        val isSuccess: Boolean = serviceImpl.deleteEnterprise(id)
        if (!isSuccess) {
            println("Enterprise {$id} deleted")
        }
        return ResponseEntity.noContent().build()
    }
}