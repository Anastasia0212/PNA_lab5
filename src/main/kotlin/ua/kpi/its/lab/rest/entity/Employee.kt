package ua.kpi.its.lab.rest.entity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name="employee")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val fullName: String,
    val dateOfEmployment: LocalDate,
    val division: Int,
    val category: String,
    val position: String,
    val salary: Int,
    val partTime: Boolean,
    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    val enterprise: Enterprise,
) : Comparable<Employee> {
    override fun compareTo(employee: Employee): Int {
        val compare = fullName.compareTo(employee.fullName)
        return if (compare != 0) compare else dateOfEmployment.compareTo(employee.dateOfEmployment) + category.compareTo(employee.category)
    }
}