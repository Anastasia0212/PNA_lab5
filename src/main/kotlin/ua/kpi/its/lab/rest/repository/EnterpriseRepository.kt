package ua.kpi.its.lab.rest.repository

import ua.kpi.its.lab.rest.entity.Enterprise
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EnterpriseRepository : JpaRepository<Enterprise, Long>