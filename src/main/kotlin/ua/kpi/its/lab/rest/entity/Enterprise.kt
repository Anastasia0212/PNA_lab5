package ua.kpi.its.lab.rest.entity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "enterprise")
data class Enterprise(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val name: String,
    val industry: String,
    val legalAddress: String,
    val numberOfDivisions: Int,
    val dateOfEstablishment: LocalDate,
    val numberOfEmployees: Int,
    val VATPayer: Boolean,
    @OneToMany(mappedBy = "enterprise", cascade = [CascadeType.ALL], orphanRemoval = true)
    val employees: List<Employee>
) : Comparable<Enterprise> {
    override fun compareTo(enterprise: Enterprise): Int {
        val compare = name.compareTo(enterprise.name)
        return if (compare != 0) compare else legalAddress.compareTo(enterprise.legalAddress)
    }
}