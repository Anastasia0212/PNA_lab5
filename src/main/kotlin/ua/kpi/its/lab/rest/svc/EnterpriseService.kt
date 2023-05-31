package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.EnterpriseRequest
import ua.kpi.its.lab.rest.dto.EnterpriseResponse

interface EnterpriseService {
    fun createEnterprise(enterpriseRequest: EnterpriseRequest): EnterpriseResponse
    fun getEnterpriseById(id: Long): EnterpriseResponse
    fun updateEnterprise(id: Long, enterpriseRequest: EnterpriseRequest): EnterpriseResponse
    fun deleteEnterprise(id: Long): Boolean
}